package ir.amirroid.jetnews.article.mappers

import ir.amirroid.jetnews.common.base.formatters.formatWithThousandsSeparator
import ir.amirroid.jetnews.date.formatDayMonthWithOptionalYear
import ir.amirroid.jetnews.article.models.ArticleDetailUiModel
import ir.amirroid.jetnews.domain.models.article.ArticleDetail

fun ArticleDetail.toUiModel(): ArticleDetailUiModel {
    return ArticleDetailUiModel(
        id = id,
        title = title,
        picture = coverImage,
        authorUser = user.name,
        formattedCommentsCount = commentsCount.formatWithThousandsSeparator(),
        formattedCreatedAt = createdAt.formatDayMonthWithOptionalYear(),
        markdownContent = bodyMarkdown
    )
}