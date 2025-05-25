package ir.amirroid.jetnews.home.models

import androidx.compose.runtime.Immutable

@Immutable
data class ArticleUiModel(
    val id: Int,
    val title: String,
    val picture: String?,
    val authorUser: String,
    val userProfilePicture: String?,
    val formattedCommentsCount: String,
    val formattedCreatedAt: String
)