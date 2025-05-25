package ir.amirroid.jetnews.data.datasources.remote.comment

import ir.amirroid.jetnews.common.base.response.Response
import ir.amirroid.jetnews.data.models.comment.CommentResponse
import ir.amirroid.jetnews.data.network.services.comment.CommentApiService
import ir.amirroid.jetnews.response.NetworkErrors

class CommentRemoteDataSourceImpl(
    private val commentApiService: CommentApiService
) : CommentRemoteDataSource {
    override suspend fun getCommentsForArticle(articleId: Int): Response<List<CommentResponse>, NetworkErrors> {
        return commentApiService.getCommentsForArticle(articleId)
    }
}