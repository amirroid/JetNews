package ir.amirroid.jetnews.article.mappers

import be.digitalia.compose.htmlconverter.htmlToAnnotatedString
import ir.amirroid.jetnews.article.models.CommentUiModel
import ir.amirroid.jetnews.date.formatDayMonthWithOptionalYear
import ir.amirroid.jetnews.domain.models.comment.Comment

fun Comment.toUiModel(): CommentUiModel {
    return CommentUiModel(
        id = id,
        authoredComment = user?.name?.takeIf { it.isNotEmpty() },
        body = htmlToAnnotatedString(bodyHtml),
        formattedCreatedAt = createdAt.formatDayMonthWithOptionalYear(),
        userProfilePicture = user?.profileImage,
        children = children.map { it.toUiModel() }
    )
}