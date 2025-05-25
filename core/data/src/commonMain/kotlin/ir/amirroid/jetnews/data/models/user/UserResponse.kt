package ir.amirroid.jetnews.data.models.user

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class UserResponse(
    @SerialName("github_username")
    val githubUsername: String? = null,
    val name: String = "null",
    @SerialName("profile_image")
    val profileImage: String? = null,
    @SerialName("profile_image_90")
    val profileImage90: String? = null,
    @SerialName("twitter_username")
    val twitterUsername: String? = null,
    @SerialName("user_id")
    val userId: Int = 0,
    val username: String = "",
    @SerialName("website_url")
    val websiteUrl: String? = null
)