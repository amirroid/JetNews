package ir.amirroid.jetnews.home.screen

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ListItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import ir.amirroid.jetnews.common.base.response.onError
import ir.amirroid.jetnews.common.base.response.onLoading
import ir.amirroid.jetnews.common.base.response.onSuccess
import ir.amirroid.jetnews.common.components.LoadingContent
import ir.amirroid.jetnews.home.models.ArticleUiModel
import ir.amirroid.jetnews.home.viewmodel.HomeViewModel
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun HomeScreen(
    viewModel: HomeViewModel = koinViewModel()
) {
    val state by viewModel.state.collectAsStateWithLifecycle()

    state
        .onSuccess { requiredState ->
            HomeScreenContent(requiredState.articles)
        }
        .onError { }
        .onLoading { LoadingContent() }
}

@Composable
fun HomeScreenContent(articles: List<ArticleUiModel>) {
    LazyColumn {
        items(articles, key = { it.id }) { article ->
            ListItem({
                Text(article.title)
            })
        }
    }
}