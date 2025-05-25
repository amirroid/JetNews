package ir.amirroid.jetnews.home.mappers

import ir.amirroid.jetnews.common.base.formatters.formatWithThousandsSeparator
import ir.amirroid.jetnews.date.formatDayMonthWithOptionalYear
import ir.amirroid.jetnews.domain.models.article.Article
import ir.amirroid.jetnews.home.models.ArticleUiModel

fun Article.toUiModel(): ArticleUiModel {
    return ArticleUiModel(
        id = id,
        title = title,
        picture = coverImage,
        authorUser = user.name,
        formattedCommentsCount = commentsCount.formatWithThousandsSeparator(),
        formattedCreatedAt = createdAt.formatDayMonthWithOptionalYear(),
        userProfilePicture = user.profileImage
    )
}