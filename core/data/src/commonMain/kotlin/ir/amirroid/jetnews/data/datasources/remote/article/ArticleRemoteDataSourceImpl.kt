package ir.amirroid.jetnews.data.datasources.remote.article

import ir.amirroid.jetnews.data.network.services.article.ArticleApiService

class ArticleRemoteDataSourceImpl(
    private val articleApiService: ArticleApiService
) : ArticleRemoteDataSource {
    override suspend fun getAllArticles(page: Int) = articleApiService.getAllArticles(page)
    override suspend fun getArticle(articleId: Int) = articleApiService.getArticle(articleId)
}