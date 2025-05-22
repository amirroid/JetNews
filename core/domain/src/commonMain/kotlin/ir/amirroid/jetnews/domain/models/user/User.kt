package ir.amirroid.jetnews.domain.models.user


data class User(
    val name: String,
    val profileImage: String?,
    val userId: Int,
    val username: String,
)