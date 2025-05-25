package ir.amirroid.jetnews.data.mappers.article_detail

import ir.amirroid.jetnews.data.mappers.user.toDomain
import ir.amirroid.jetnews.data.models.article.ArticleDetailResponse
import ir.amirroid.jetnews.domain.models.article.ArticleDetail

fun ArticleDetailResponse.toDomain(): ArticleDetail {
    return ArticleDetail(
        id = id,
        title = title,
        description = description,
        coverImage = coverImage,
        language = language,
        createdAt = createdAt,
        bodyMarkdown = bodyMarkdown,
        bodyHtml = bodyHtml,
        commentsCount = commentsCount,
        user = user.toDomain(),
        tags = tags
    )
}