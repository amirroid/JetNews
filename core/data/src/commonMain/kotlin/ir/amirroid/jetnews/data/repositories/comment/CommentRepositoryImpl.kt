package ir.amirroid.jetnews.data.repositories.comment

import ir.amirroid.jetnews.common.base.response.Response
import ir.amirroid.jetnews.common.base.response.mapList
import ir.amirroid.jetnews.data.datasources.remote.comment.CommentRemoteDataSource
import ir.amirroid.jetnews.data.mappers.comment.toDomain
import ir.amirroid.jetnews.domain.models.comment.Comment
import ir.amirroid.jetnews.domain.repositories.comment.CommentRepository
import ir.amirroid.jetnews.response.NetworkErrors

class CommentRepositoryImpl(
    private val commentRemoteDataSource: CommentRemoteDataSource
) : CommentRepository {
    override suspend fun getCommentsForArticle(articleId: Int): Response<List<Comment>, NetworkErrors> {
        return commentRemoteDataSource.getCommentsForArticle(articleId).mapList { it.toDomain() }
    }
}