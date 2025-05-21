package ir.amirroid.jetnews.data.models.article


import kotlinx.serialization.Serializable
import kotlinx.serialization.SerialName

@Serializable
data class ArticleResponse(
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
    val crossPostedAt: String?,
    val description: String,
    @SerialName("edited_at")
    val editedAt: String?,
    @SerialName("flare_tag")
    val flareTag: FlareTag? = null,
    val id: Long,
    val language: String,
    @SerialName("last_comment_at")
    val lastCommentAt: String,
    val organization: Organization? = null,
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
    val tagList: List<String> = emptyList(),
    val tags: String,
    val title: String,
    @SerialName("type_of")
    val typeOf: String,
    val url: String,
    val user: User
) {
    @Serializable
    data class FlareTag(
        @SerialName("bg_color_hex")
        val bgColorHex: String,
        val name: String,
        @SerialName("text_color_hex")
        val textColorHex: String
    )

    @Serializable
    data class Organization(
        val name: String,
        @SerialName("profile_image")
        val profileImage: String,
        @SerialName("profile_image_90")
        val profileImage90: String,
        val slug: String,
        val username: String
    )

    @Serializable
    data class User(
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
}