package ir.amirroid.jetnews.domain.models.comment


import ir.amirroid.jetnews.domain.models.user.User

data class Comment(
    val id: String,
    val bodyHtml: String,
    val createdAt: String,
    val user: User?,
    val children: List<Comment>,
)
