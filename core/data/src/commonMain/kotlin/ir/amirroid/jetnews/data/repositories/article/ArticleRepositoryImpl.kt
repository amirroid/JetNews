package ir.amirroid.jetnews.data.repositories.article

import androidx.paging.PagingConfig
import androidx.paging.map
import app.cash.paging.Pager
import app.cash.paging.PagingData
import ir.amirroid.jetnews.common.base.response.Response
import ir.amirroid.jetnews.common.base.response.map
import ir.amirroid.jetnews.data.datasources.remote.article.ArticleRemoteDataSource
import ir.amirroid.jetnews.data.extensions.removeDuplicatesBy
import ir.amirroid.jetnews.data.mappers.article.toDomain
import ir.amirroid.jetnews.data.mappers.article_detail.toDomain
import ir.amirroid.jetnews.data.network.services.article.ArticleApiService
import ir.amirroid.jetnews.data.paging.article.ArticlePagingSource
import ir.amirroid.jetnews.domain.models.article.Article
import ir.amirroid.jetnews.domain.models.article.ArticleDetail
import ir.amirroid.jetnews.domain.repositories.article.ArticleRepository
import ir.amirroid.jetnews.response.NetworkErrors
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.map

class ArticleRepositoryImpl(
    private val remoteDataSource: ArticleRemoteDataSource
) : ArticleRepository {
    override fun getAllArticles(): Flow<PagingData<Article>> {
        return Pager(
            config = PagingConfig(ArticleApiService.PER_PAGE_COUNT),
            pagingSourceFactory = { ArticlePagingSource(remoteDataSource) },
        ).flow.map { pagingData -> pagingData.map { it.toDomain() }.removeDuplicatesBy { it.id } }
            .distinctUntilChanged()
    }

    override suspend fun getArticle(articleId: Int): Response<ArticleDetail, NetworkErrors> {
        return remoteDataSource.getArticle(articleId).map { it.toDomain() }
    }
}