package ir.amirroid.jetnews.domain.repositories.article

import androidx.paging.PagingData
import ir.amirroid.jetnews.common.base.response.Response
import ir.amirroid.jetnews.domain.models.article.Article
import ir.amirroid.jetnews.domain.models.article.ArticleDetail
import ir.amirroid.jetnews.response.NetworkErrors
import kotlinx.coroutines.flow.Flow

interface ArticleRepository {
    fun getAllArticles(): Flow<PagingData<Article>>
    suspend fun getArticle(articleId: Int): Response<ArticleDetail, NetworkErrors>
}