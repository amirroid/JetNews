package ir.amirroid.jetnews.data.mappers.comment

import ir.amirroid.jetnews.data.mappers.user.toDomain
import ir.amirroid.jetnews.data.models.comment.CommentResponse
import ir.amirroid.jetnews.domain.models.comment.Comment

fun CommentResponse.toDomain(): Comment {
    return Comment(
        id = idCode,
        bodyHtml = bodyHtml,
        createdAt = createdAt,
        user = user?.toDomain(),
        children = children.map { it.toDomain() }
    )
}