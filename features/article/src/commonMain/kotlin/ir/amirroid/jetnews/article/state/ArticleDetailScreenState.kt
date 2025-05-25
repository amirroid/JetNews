package ir.amirroid.jetnews.article.state

import androidx.compose.runtime.Immutable
import ir.amirroid.jetnews.domain.models.article.Article

@Immutable
data class ArticleDetailScreenState(
    val article: Article,
    val comments: List<String>
)