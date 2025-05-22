package ir.amirroid.jetnews.data.mappers.article

import ir.amirroid.jetnews.data.models.article.ArticleDetailResponse
import ir.amirroid.jetnews.domain.models.article.ArticleDetail
import ir.amirroid.jetnews.domain.models.user.User

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
        user = User(
            name = user.name,
            profileImage = user.profileImage90,
            userId = user.userId,
            username = user.username
        )
    )
}