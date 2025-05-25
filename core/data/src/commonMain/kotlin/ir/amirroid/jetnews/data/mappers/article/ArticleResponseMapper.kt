package ir.amirroid.jetnews.data.mappers.article

import ir.amirroid.jetnews.data.mappers.user.toDomain
import ir.amirroid.jetnews.data.models.article.ArticleResponse
import ir.amirroid.jetnews.domain.models.article.Article

fun ArticleResponse.toDomain(): Article {
    return Article(
        id = id,
        title = title,
        description = description,
        coverImage = coverImage,
        language = language,
        createdAt = createdAt,
        commentsCount = commentsCount,
        user = user.toDomain()
    )
}