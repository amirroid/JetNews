package ir.amirroid.jetnews.domain.repositories.comment

import ir.amirroid.jetnews.common.base.response.Response
import ir.amirroid.jetnews.domain.models.comment.Comment
import ir.amirroid.jetnews.response.NetworkErrors

interface CommentRepository {
    suspend fun getCommentsForArticle(articleId: Int): Response<List<Comment>, NetworkErrors>
}