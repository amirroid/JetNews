package ir.amirroid.jetnews.domain.models.article


data class Article(
    val id: Long,
    val title: String,
    val description: String,
    val coverImage: String?,
    val language: String,
    val createdAt: String,
    val commentsCount: Int,
    val user: User
) {
    data class User(
        val name: String,
        val profileImage: String?,
        val userId: Int,
        val username: String,
    )
}