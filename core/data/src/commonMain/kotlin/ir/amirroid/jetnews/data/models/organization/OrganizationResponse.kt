package ir.amirroid.jetnews.data.models.organization

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class OrganizationResponse(
    val name: String,
    @SerialName("profile_image")
    val profileImage: String,
    @SerialName("profile_image_90")
    val profileImage90: String,
    val slug: String,
    val username: String
)