package ir.amirroid.jetnews.data.mappers.article

import ir.amirroid.jetnews.database.entities.ArticleEntity
import ir.amirroid.jetnews.domain.models.article.Article
import ir.amirroid.jetnews.domain.models.user.User

fun ArticleEntity.toDomain(): Article {
    return Article(
        id = id,
        title = title,
        description = description,
        coverImage = coverImage,
        language = language,
        createdAt = createdAt,
        commentsCount = commentsCount,
        user = User(
            name = username,
            userId = userId,
            profileImage = userProfileImage,
            username = userUsername
        )
    )
}