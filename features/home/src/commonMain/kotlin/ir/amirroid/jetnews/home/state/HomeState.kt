package ir.amirroid.jetnews.home.state

import androidx.compose.runtime.Immutable
import ir.amirroid.jetnews.home.models.ArticleUiModel

@Immutable
data class HomeState(
    val articles: List<ArticleUiModel>
)