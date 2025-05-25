package ir.amirroid.jetnews.data.models.comment


import ir.amirroid.jetnews.data.models.user.UserResponse
import kotlinx.serialization.Serializable
import kotlinx.serialization.SerialName

@Serializable
data class CommentResponse(
    @SerialName("body_html")
    val bodyHtml: String,
    val children: List<CommentResponse>,
    @SerialName("created_at")
    val createdAt: String,
    @SerialName("id_code")
    val idCode: String,
    @SerialName("type_of")
    val typeOf: String,
    val user: UserResponse?
)