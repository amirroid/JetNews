package ir.amirroid.jetnews.domain.models.article

import ir.amirroid.jetnews.domain.models.user.User


data class ArticleDetail(
    val id: Long,
    val title: String,
    val description: String,
    val coverImage: String?,
    val language: String,
    val createdAt: String,
    val bodyMarkdown: String,
    val bodyHtml: String,
    val commentsCount: Int,
    val user: User
)