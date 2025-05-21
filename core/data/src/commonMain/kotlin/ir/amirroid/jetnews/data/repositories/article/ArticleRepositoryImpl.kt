package ir.amirroid.jetnews.data.repositories.article

import ir.amirroid.jetnews.common.base.response.Response
import ir.amirroid.jetnews.common.base.response.mapList
import ir.amirroid.jetnews.data.datasources.remote.article.ArticleRemoteDataSource
import ir.amirroid.jetnews.data.mappers.article.toDomain
import ir.amirroid.jetnews.domain.models.article.Article
import ir.amirroid.jetnews.domain.repositories.article.ArticleRepository
import ir.amirroid.jetnews.response.NetworkErrors

class ArticleRepositoryImpl(
    private val remoteDataSource: ArticleRemoteDataSource
) : ArticleRepository {
    override suspend fun getAllArticles(): Response<List<Article>, NetworkErrors> {
        return remoteDataSource.getAllArticles().mapList { it.toDomain() }
    }
}