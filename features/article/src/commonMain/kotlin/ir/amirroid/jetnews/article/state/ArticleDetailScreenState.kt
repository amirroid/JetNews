package ir.amirroid.jetnews.article.state

import androidx.compose.runtime.Immutable
import ir.amirroid.jetnews.article.models.ArticleDetailUiModel
import ir.amirroid.jetnews.article.models.CommentUiModel

@Immutable
data class ArticleDetailScreenState(
    val article: ArticleDetailUiModel,
    val comments: List<CommentUiModel>,
)
