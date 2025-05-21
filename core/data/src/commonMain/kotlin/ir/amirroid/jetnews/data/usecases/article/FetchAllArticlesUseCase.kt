package ir.amirroid.jetnews.data.usecases.article

import ir.amirroid.jetnews.common.base.response.Response
import ir.amirroid.jetnews.data.repositories.article.ArticleRepository
import ir.amirroid.jetnews.domain.models.article.Article
import ir.amirroid.jetnews.response.NetworkErrors

class FetchAllArticlesUseCase(
    private val repository: ArticleRepository
) {
    suspend operator fun invoke(): Response<List<Article>, NetworkErrors> {
        return repository.getAllArticles()
    }
}