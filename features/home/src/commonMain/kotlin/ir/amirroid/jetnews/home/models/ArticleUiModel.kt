package ir.amirroid.jetnews.home.models

import androidx.compose.runtime.Immutable

@Immutable
data class ArticleUiModel(
    val id: Long,
    val title: String
)