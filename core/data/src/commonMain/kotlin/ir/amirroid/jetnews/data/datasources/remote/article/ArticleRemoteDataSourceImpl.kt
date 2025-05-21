package ir.amirroid.jetnews.data.datasources.remote.article

import ir.amirroid.jetnews.data.network.services.article.ArticleApiService

class ArticleRemoteDataSourceImpl(
    private val articleApiService: ArticleApiService
) : ArticleRemoteDataSource {
    override suspend fun getAllArticles() = articleApiService.getAllArticles()
}