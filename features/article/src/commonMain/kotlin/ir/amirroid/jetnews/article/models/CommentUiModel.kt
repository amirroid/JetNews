package ir.amirroid.jetnews.article.models

import androidx.compose.runtime.Immutable
import androidx.compose.ui.text.AnnotatedString

@Immutable
data class CommentUiModel(
    val id: String,
    val authoredComment: String?,
    val body: AnnotatedString,
    val formattedCreatedAt: String,
    val userProfilePicture: String?,
    val children: List<CommentUiModel>
)
