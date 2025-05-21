package ir.amirroid.jetnews.data.mappers.article

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
        user = Article.User(
            name = user.name,
            profileImage = user.profileImage90,
            userId = user.userId,
            username = user.username
        )
    )
}