package ir.amirroid.jetnews.domain.usecases.article

import ir.amirroid.jetnews.common.base.response.Response
import ir.amirroid.jetnews.domain.models.article.ArticleDetail
import ir.amirroid.jetnews.domain.repositories.article.ArticleRepository
import ir.amirroid.jetnews.response.NetworkErrors

class FetchSingleArticleUseCase(
    private val articleRepository: ArticleRepository
) {
    suspend operator fun invoke(articleId: Int): Response<ArticleDetail, NetworkErrors> {
        return articleRepository.getArticle(articleId)
    }
}