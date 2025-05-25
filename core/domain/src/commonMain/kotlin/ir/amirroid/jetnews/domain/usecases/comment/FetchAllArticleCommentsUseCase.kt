package ir.amirroid.jetnews.domain.usecases.comment

import ir.amirroid.jetnews.common.base.response.Response
import ir.amirroid.jetnews.domain.models.comment.Comment
import ir.amirroid.jetnews.domain.repositories.comment.CommentRepository
import ir.amirroid.jetnews.response.NetworkErrors

class FetchAllArticleCommentsUseCase(
    private val repository: CommentRepository
) {
    suspend operator fun invoke(articleId: Int): Response<List<Comment>, NetworkErrors> {
        return repository.getCommentsForArticle(articleId)
    }
}