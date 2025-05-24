package ir.amirroid.jetnews.data.repositories.article

import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.map
import ir.amirroid.jetnews.common.base.response.Response
import ir.amirroid.jetnews.common.base.response.map
import ir.amirroid.jetnews.data.datasources.remote.article.ArticleRemoteDataSource
import ir.amirroid.jetnews.data.mappers.article.toDomain
import ir.amirroid.jetnews.data.mappers.article_detail.toDomain
import ir.amirroid.jetnews.data.network.services.article.ArticleApiService
import ir.amirroid.jetnews.data.paging.article.ArticleRemoteMediator
import ir.amirroid.jetnews.database.dao.ArticleDao
import ir.amirroid.jetnews.domain.models.article.Article
import ir.amirroid.jetnews.domain.models.article.ArticleDetail
import ir.amirroid.jetnews.domain.repositories.article.ArticleRepository
import ir.amirroid.jetnews.response.NetworkErrors
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class ArticleRepositoryImpl(
    private val articleRemoteMediator: ArticleRemoteMediator,
    private val articleDao: ArticleDao,
    private val remoteDataSource: ArticleRemoteDataSource
) : ArticleRepository {
    @OptIn(ExperimentalPagingApi::class)
    override fun getAllArticles(): Flow<PagingData<Article>> {
        return Pager(
            config = PagingConfig(
                pageSize = ArticleApiService.PER_PAGE_COUNT,
                prefetchDistance = ArticleApiService.PER_PAGE_COUNT,
                initialLoadSize = ArticleApiService.PER_PAGE_COUNT * 2
            ),
            pagingSourceFactory = { articleDao.getPagination() },
            remoteMediator = articleRemoteMediator
        ).flow.map { pagingData -> pagingData.map { it.toDomain() } }
    }

    override suspend fun getArticle(articleId: Int): Response<ArticleDetail, NetworkErrors> {
        return remoteDataSource.getArticle(articleId).map { it.toDomain() }
    }
}