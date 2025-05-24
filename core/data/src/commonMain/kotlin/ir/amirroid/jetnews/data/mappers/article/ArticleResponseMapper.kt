package ir.amirroid.jetnews.data.mappers.article

import ir.amirroid.jetnews.data.models.article.ArticleResponse
import ir.amirroid.jetnews.database.entities.ArticleEntity

fun ArticleResponse.toArticleEntity(): ArticleEntity {
    return ArticleEntity(
        id = id,
        title = title,
        description = description,
        coverImage = coverImage,
        language = language,
        createdAt = createdAt,
        commentsCount = commentsCount,
        username = user.name,
        userProfileImage = user.profileImage90,
        userId = user.userId,
        userUsername = user.username
    )
}