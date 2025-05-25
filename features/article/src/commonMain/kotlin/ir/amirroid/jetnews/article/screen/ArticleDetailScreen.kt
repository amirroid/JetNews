package ir.amirroid.jetnews.article.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import coil3.compose.AsyncImage
import ir.amirroid.jetnews.article.models.ArticleDetailUiModel
import ir.amirroid.jetnews.article.models.CommentUiModel
import ir.amirroid.jetnews.article.state.ArticleDetailScreenState
import ir.amirroid.jetnews.article.viewmodel.ArticleDetailViewModel
import ir.amirroid.jetnews.common.base.response.onError
import ir.amirroid.jetnews.common.base.response.onLoading
import ir.amirroid.jetnews.common.base.response.onSuccess
import ir.amirroid.jetnews.common.components.LoadingContent
import ir.amirroid.jetnews.common.modifiers.horizontalPadding
import ir.amirroid.jetnews.common.modifiers.topPadding
import ir.amirroid.jetnews.common.modifiers.verticalPadding
import ir.amirroid.jetnews.common.operators.plus
import ir.amirroid.jetnews.markdown.LazyMarkdown
import ir.amirroid.jetnews.resources.Resources
import ir.amirroid.jetnews.theme.components.JetAssistChip
import ir.amirroid.jetnews.theme.components.JetCard
import ir.amirroid.jetnews.theme.components.JetCenterAlignedTopAppBar
import ir.amirroid.jetnews.theme.components.JetIcon
import ir.amirroid.jetnews.theme.components.JetIconButton
import ir.amirroid.jetnews.theme.components.JetListItem
import ir.amirroid.jetnews.theme.components.JetText
import ir.amirroid.jetnews.theme.locales.extraShapes
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.resources.vectorResource
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun ArticleDetailScreen(
    onBackPress: () -> Unit,
    viewModel: ArticleDetailViewModel = koinViewModel()
) {
    val state by viewModel.state.collectAsStateWithLifecycle()

    state
        .onSuccess {
            ArticleDetail(it, onBackPress)
        }
        .onLoading { LoadingContent() }
        .onError {
            Text(it.toString())
        }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ArticleDetail(
    state: ArticleDetailScreenState,
    onBackPress: () -> Unit,
) {
    val article = state.article
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()
    Column {
        JetCenterAlignedTopAppBar(
            title = {
                JetText(stringResource(Resources.string.appName))
            },
            navigationIcon = {
                JetIconButton(onClick = onBackPress) {
                    JetIcon(
                        imageVector = vectorResource(Resources.drawable.arrowBack),
                        contentDescription = "back"
                    )
                }
            },
            scrollBehavior = scrollBehavior
        )
        SelectionContainer(
            modifier = Modifier
                .nestedScroll(scrollBehavior.nestedScrollConnection)
        ) {
            LazyMarkdown(
                content = article.markdownContent,
                modifier = Modifier
                    .horizontalPadding()
                    .fillMaxWidth(),
                paddingValues = WindowInsets.navigationBars.asPaddingValues() + PaddingValues(
                    vertical = verticalPadding
                ),
                verticalArrangement = Arrangement.spacedBy(12.dp),
                beforeMarkdownScope = {
                    item("title") {
                        JetText(
                            article.title,
                            style = MaterialTheme.typography.headlineMedium,
                            modifier = Modifier.horizontalPadding()
                        )
                    }
                    item("article_info") {
                        ArticleInfo(article)
                    }
                    if (article.tags.isNotEmpty()) {
                        item("tags") {
                            ArticleTags(article)
                        }
                    }
                    article.picture?.let {
                        item("picture_bar") {
                            AsyncImage(
                                model = it,
                                contentDescription = article.title,
                                modifier = Modifier.fillMaxWidth(),
                                contentScale = ContentScale.FillWidth
                            )
                        }
                    }
                },
                afterMarkdownScope = {
                    if (state.comments.isNotEmpty()) {
                        item("comments_bar") {
                            JetText(
                                "Comments",
                                modifier = Modifier.horizontalPadding().topPadding(),
                                style = MaterialTheme.typography.titleLarge
                            )
                        }
                        state.comments.forEach {
                            commentItem(it)
                        }
                    }
                }
            )
        }
    }
}

@Composable
fun ArticleInfo(article: ArticleDetailUiModel) {
    FlowRow(
        verticalArrangement = Arrangement.Center,
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        modifier = Modifier.alpha(0.8f).horizontalPadding(),
        itemVerticalAlignment = Alignment.CenterVertically
    ) {
        JetIcon(
            imageVector = vectorResource(Resources.drawable.user),
            contentDescription = null,
        )
        AsyncImage(
            model = article.userProfilePicture ?: Resources.drawable.user,
            contentDescription = null,
            modifier = Modifier
                .clip(extraShapes.medium).size(16.dp)
                .background(MaterialTheme.colorScheme.surface),
            contentScale = ContentScale.Crop
        )
        JetText(
            text = article.authorUser,
            style = MaterialTheme.typography.labelLarge,
        )
        JetIcon(
            imageVector = vectorResource(Resources.drawable.clock),
            contentDescription = null,
            modifier = Modifier.padding(start = 12.dp).size(16.dp)
        )
        JetText(
            text = article.formattedCreatedAt,
            style = MaterialTheme.typography.labelLarge
        )
        JetIcon(
            imageVector = vectorResource(Resources.drawable.comments),
            contentDescription = null,
            modifier = Modifier.padding(start = 12.dp).size(16.dp)
        )
        JetText(
            text = article.formattedCommentsCount,
            style = MaterialTheme.typography.labelLarge
        )
    }
}

@Composable
fun ArticleTags(article: ArticleDetailUiModel) {
    FlowRow(
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        modifier = Modifier.alpha(0.8f).horizontalPadding(),
        itemVerticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = stringResource(Resources.string.tags) + ":",
            style = MaterialTheme.typography.labelMedium
        )
        article.tags.forEach {
            JetAssistChip(
                onClick = {},
                label = {
                    JetText(it)
                }
            )
        }
    }
}

fun LazyListScope.commentItem(comment: CommentUiModel, index: Int = 0) {
    item("comment_item_${comment.id}") {
        CommentItem(comment, index)
    }
    comment.children.forEach {
        commentItem(it, index + 1)
    }
}

@Composable
fun CommentItem(comment: CommentUiModel, index: Int) {
    Row(
        modifier = Modifier
            .horizontalPadding()
            .padding(start = 24.dp * index.minus(1).coerceAtLeast(0))
    ) {
        if (index != 0) {
            Icon(
                vectorResource(Resources.drawable.under),
                contentDescription = null,
                modifier = Modifier.alpha(.7f).padding(8.dp)
            )
        }
        JetCard {
            JetListItem(
                headlineContent = {
                    JetText(comment.authoredComment ?: stringResource(Resources.string.unknownUser))
                },
                supportingContent = {
                    JetText(comment.body)
                },
                overlineContent = {
                    JetText(comment.formattedCreatedAt)
                },
                leadingContent = {
                    AsyncImage(
                        model = comment.userProfilePicture ?: Resources.drawable.user,
                        contentDescription = null,
                        modifier = Modifier
                            .clip(extraShapes.medium).size(36.dp)
                            .background(MaterialTheme.colorScheme.surface),
                        contentScale = ContentScale.Crop
                    )
                }
            )
        }
    }
}