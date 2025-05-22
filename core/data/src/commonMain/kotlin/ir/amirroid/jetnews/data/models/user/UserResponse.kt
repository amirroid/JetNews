package ir.amirroid.jetnews.data.models.user

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class UserResponse(
    @SerialName("github_username")
    val githubUsername: String?,
    val name: String,
    @SerialName("profile_image")
    val profileImage: String,
    @SerialName("profile_image_90")
    val profileImage90: String,
    @SerialName("twitter_username")
    val twitterUsername: String?,
    @SerialName("user_id")
    val userId: Int,
    val username: String,
    @SerialName("website_url")
    val websiteUrl: String?
)