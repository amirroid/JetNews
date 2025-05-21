package ir.amirroid.jetnews.domain.repositories.article

import ir.amirroid.jetnews.common.base.response.Response
import ir.amirroid.jetnews.domain.models.article.Article
import ir.amirroid.jetnews.response.NetworkErrors

interface ArticleRepository {
    suspend fun getAllArticles(): Response<List<Article>, NetworkErrors>
}