package ir.amirroid.jetnews.data.models.article


import ir.amirroid.jetnews.data.models.organization.OrganizationResponse
import ir.amirroid.jetnews.data.models.user.UserResponse
import kotlinx.serialization.Serializable
import kotlinx.serialization.SerialName

@Serializable
data class ArticleDetailResponse(
    @SerialName("body_html")
    val bodyHtml: String,
    @SerialName("body_markdown")
    val bodyMarkdown: String,
    @SerialName("canonical_url")
    val canonicalUrl: String,
    @SerialName("collection_id")
    val collectionId: Long?,
    @SerialName("comments_count")
    val commentsCount: Int,
    @SerialName("cover_image")
    val coverImage: String?,
    @SerialName("created_at")
    val createdAt: String,
    @SerialName("crossposted_at")
    val crosspostedAt: String?,
    val description: String,
    @SerialName("edited_at")
    val editedAt: String?,
    val id: Long,
    val language: String,
    @SerialName("last_comment_at")
    val lastCommentAt: String,
    val organization: OrganizationResponse? = null,
    val path: String,
    @SerialName("positive_reactions_count")
    val positiveReactionsCount: Int,
    @SerialName("public_reactions_count")
    val publicReactionsCount: Int,
    @SerialName("published_at")
    val publishedAt: String,
    @SerialName("published_timestamp")
    val publishedTimestamp: String,
    @SerialName("readable_publish_date")
    val readablePublishDate: String,
    @SerialName("reading_time_minutes")
    val readingTimeMinutes: Int,
    val slug: String,
    @SerialName("social_image")
    val socialImage: String,
    @SerialName("subforem_id")
    val subforemId: Int,
    @SerialName("tag_list")
    val tagList: String = "",
    val tags: List<String>,
    val title: String,
    @SerialName("type_of")
    val typeOf: String,
    val url: String,
    val user: UserResponse
)