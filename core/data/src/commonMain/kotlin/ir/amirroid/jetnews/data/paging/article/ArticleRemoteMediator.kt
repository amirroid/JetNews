package ir.amirroid.jetnews.data.paging.article

import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadType
import androidx.paging.PagingState
import androidx.paging.RemoteMediator
import ir.amirroid.jetnews.common.base.response.onSuccess
import ir.amirroid.jetnews.data.datasources.locale.article.ArticleLocaleDatasource
import ir.amirroid.jetnews.data.datasources.locale.article_remote_keys.ArticleRemoteKeysLocaleDataSource
import ir.amirroid.jetnews.data.datasources.remote.article.ArticleRemoteDataSource
import ir.amirroid.jetnews.data.mappers.article.toArticleEntity
import ir.amirroid.jetnews.data.models.article.ArticleResponse
import ir.amirroid.jetnews.database.AppDatabase
import ir.amirroid.jetnews.database.entities.ArticleEntity
import ir.amirroid.jetnews.database.entities.ArticleRemoteKeyEntity
import ir.amirroid.jetnews.database.utils.dbTransaction

@OptIn(ExperimentalPagingApi::class)
class ArticleRemoteMediator(
    private val articleRemoteDataSource: ArticleRemoteDataSource,
    private val localeDatasource: ArticleLocaleDatasource,
    private val articleRemoteKeysLocaleDataSource: ArticleRemoteKeysLocaleDataSource,
    private val appDatabase: AppDatabase
) : RemoteMediator<Int, ArticleEntity>() {

    override suspend fun load(
        loadType: LoadType,
        state: PagingState<Int, ArticleEntity>
    ): MediatorResult {
        val page = when (loadType) {
            LoadType.REFRESH -> 1
            LoadType.PREPEND -> return MediatorResult.Success(endOfPaginationReached = false)
            LoadType.APPEND -> {
                val remoteKey = getRemoteKeyForLastItem(state)
                remoteKey?.nextKey ?: return MediatorResult.Success(endOfPaginationReached = true)
            }
        }

        val response = articleRemoteDataSource.getAllArticles(page.toInt())
        response.onSuccess { articles ->
            appDatabase.dbTransaction {
                if (loadType == LoadType.REFRESH) {
                    articleRemoteKeysLocaleDataSource.clearAll()
                    localeDatasource.clearAll()
                }

                val remoteKeys = articles.toRemoteKeys(
                    currentPage = page,
                    endOfPagination = articles.size < state.config.pageSize
                )
                articleRemoteKeysLocaleDataSource.upsertAll(remoteKeys)
                localeDatasource.upsertAll(articles.map { it.toArticleEntity() })
            }
            return MediatorResult.Success(endOfPaginationReached = articles.size < state.config.pageSize)
        }

        return MediatorResult.Error(Throwable("Unexpected error during article fetching"))

    }

    private suspend fun getRemoteKeyForLastItem(state: PagingState<Int, ArticleEntity>): ArticleRemoteKeyEntity? {
        return state.lastItemOrNull()?.let { item ->
            articleRemoteKeysLocaleDataSource.getById(item.id)
        }
    }

    private fun List<ArticleResponse>.toRemoteKeys(
        currentPage: Long,
        endOfPagination: Boolean
    ): List<ArticleRemoteKeyEntity> {
        return map { article ->
            ArticleRemoteKeyEntity(
                articleId = article.id,
                nextKey = if (endOfPagination) null else currentPage + 1
            )
        }
    }
}