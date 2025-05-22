package ir.amirroid.jetnews.article.models

import androidx.compose.runtime.Immutable

@Immutable
data class ArticleDetailUiModel(
    val id: Long,
    val title: String,
    val picture: String?,
    val authorUser: String,
    val formattedCommentsCount: String,
    val formattedCreatedAt: String,
    val markdownContent: String
)