package ir.amirroid.jetnews.data.network.services.comment

import ir.amirroid.jetnews.common.base.response.Response
import ir.amirroid.jetnews.data.models.comment.CommentResponse
import ir.amirroid.jetnews.response.NetworkErrors

interface CommentApiService {
    suspend fun getCommentsForArticle(articleId: Int): Response<List<CommentResponse>, NetworkErrors>
}