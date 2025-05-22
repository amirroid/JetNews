package ir.amirroid.jetnews.data.repositories.article

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.map
import ir.amirroid.jetnews.common.base.response.Response
import ir.amirroid.jetnews.common.base.response.map
import ir.amirroid.jetnews.data.datasources.remote.article.ArticleRemoteDataSource
import ir.amirroid.jetnews.data.mappers.article.toDomain
import ir.amirroid.jetnews.data.pagingsources.article.ArticlePagingSource
import ir.amirroid.jetnews.domain.models.article.Article
import ir.amirroid.jetnews.domain.models.article.ArticleDetail
import ir.amirroid.jetnews.domain.repositories.article.ArticleRepository
import ir.amirroid.jetnews.response.NetworkErrors
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class ArticleRepositoryImpl(
    private val remoteDataSource: ArticleRemoteDataSource
) : ArticleRepository {
    override fun getAllArticles(): Flow<PagingData<Article>> {
        return Pager(
            config = PagingConfig(pageSize = 1),
            pagingSourceFactory = {
                ArticlePagingSource(remoteDataSource)
            }
        ).flow.map { pagingData ->
            pagingData.map { it.toDomain() }
        }
    }

    override suspend fun getArticle(articleId: Int): Response<ArticleDetail, NetworkErrors> {
        return remoteDataSource.getArticle(articleId).map { it.toDomain() }
    }
}