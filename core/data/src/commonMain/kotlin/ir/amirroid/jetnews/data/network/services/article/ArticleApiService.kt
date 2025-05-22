package ir.amirroid.jetnews.data.network.services.article

import ir.amirroid.jetnews.common.base.response.Response
import ir.amirroid.jetnews.data.models.article.ArticleDetailResponse
import ir.amirroid.jetnews.data.models.article.ArticleResponse
import ir.amirroid.jetnews.response.NetworkErrors

interface ArticleApiService {
    suspend fun getAllArticles(page: Int): Response<List<ArticleResponse>, NetworkErrors>
    suspend fun getArticle(articleId: Int): Response<ArticleDetailResponse, NetworkErrors>
}