package ir.amirroid.jetnews.home.screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import ir.amirroid.jetnews.common.modifiers.horizontalPadding
import ir.amirroid.jetnews.common.modifiers.thenIfNotNull
import ir.amirroid.jetnews.home.models.ArticleUiModel
import ir.amirroid.jetnews.home.viewmodel.HomeViewModel
import ir.amirroid.jetnews.paging.components.handlePagingStates
import ir.amirroid.jetnews.paging.state.LazyPagingSourceState
import ir.amirroid.jetnews.paging.state.collectAsLazyPagingSourceState
import ir.amirroid.jetnews.resources.Resources
import ir.amirroid.jetnews.theme.components.JetCenterAlignedTopAppBar
import ir.amirroid.jetnews.theme.locales.extraShapes
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.resources.vectorResource
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun HomeScreen(
    onClickArticles: (Long) -> Unit,
    viewModel: HomeViewModel = koinViewModel(),
) {
    val articles = viewModel.articles.collectAsLazyPagingSourceState()
    HomeScreenContent(articles, onClickArticles)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreenContent(
    articles: LazyPagingSourceState<ArticleUiModel>,
    onClickArticles: (Long) -> Unit,
) {
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()
    Column {
        JetCenterAlignedTopAppBar(
            title = {
                Text(stringResource(Resources.string.appName))
            },
            scrollBehavior = scrollBehavior
        )
        LazyColumn(
            contentPadding = WindowInsets.navigationBars.asPaddingValues(),
            modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection)
        ) {
            items(articles.itemCount, key = articles.itemKey { it.id }) { index ->
                articles[index]?.let {
                    ArticleItem(it, onClick = {
                        onClickArticles.invoke(it.id)
                    })
                }
            }
            handlePagingStates(articles)
        }
    }
}

@Composable
fun ArticleItem(article: ArticleUiModel, onClick: () -> Unit) {
    var itemHeight by remember { mutableStateOf<Dp?>(null) }
    val density = LocalDensity.current

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = onClick)
            .horizontalPadding()
            .padding(vertical = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        article.picture?.let { picture ->
            AsyncImage(
                model = picture,
                contentDescription = article.title,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .clip(extraShapes.medium)
                    .widthIn(max = 300.dp)
                    .fillMaxWidth(0.3f)
                    .aspectRatio(1f)
                    .onSizeChanged {
                        itemHeight = with(density) { it.height.toDp() }
                    }
            )
        }

        Column(
            modifier = Modifier
                .thenIfNotNull(itemHeight) { height(it) }
                .fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Text(
                text = article.title,
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier.thenIfNotNull(itemHeight) { weight(1f) }
            )

            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                modifier = Modifier.alpha(0.8f)
            ) {
                Icon(
                    imageVector = vectorResource(Resources.drawable.user),
                    contentDescription = null,
                    modifier = Modifier.size(16.dp)
                )
                Text(
                    text = article.authorUser,
                    style = MaterialTheme.typography.labelSmall,
                    overflow = TextOverflow.Ellipsis,
                    maxLines = 1,
                    modifier = Modifier.weight(1f)
                )
                Icon(
                    imageVector = vectorResource(Resources.drawable.clock),
                    contentDescription = null,
                    modifier = Modifier.size(16.dp)
                )
                Text(
                    text = article.formattedCreatedAt,
                    style = MaterialTheme.typography.labelLarge
                )
                Icon(
                    imageVector = vectorResource(Resources.drawable.comments),
                    contentDescription = null,
                    modifier = Modifier.padding(start = 4.dp).size(16.dp)
                )
                Text(
                    text = article.formattedCommentsCount,
                    style = MaterialTheme.typography.labelLarge
                )
            }
        }
    }
}