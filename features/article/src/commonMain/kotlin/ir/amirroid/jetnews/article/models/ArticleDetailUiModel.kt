package ir.amirroid.jetnews.article.models

import androidx.compose.runtime.Immutable

@Immutable
data class ArticleDetailUiModel(
    val id: Int,
    val title: String,
    val picture: String?,
    val authorUser: String,
    val userProfilePicture: String?,
    val formattedCommentsCount: String,
    val formattedCreatedAt: String,
    val markdownContent: String,
    val tags: List<String>
)