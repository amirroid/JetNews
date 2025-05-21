package ir.amirroid.jetnews.data.datasources.remote.article

import ir.amirroid.jetnews.common.base.response.Response
import ir.amirroid.jetnews.data.models.article.ArticleResponse
import ir.amirroid.jetnews.response.NetworkErrors

interface ArticleRemoteDataSource {
    suspend fun getAllArticles(): Response<List<ArticleResponse>, NetworkErrors>
}