package ir.amirroid.jetnews.paging.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.paging.LoadState
import ir.amirroid.jetnews.common.components.LoadingContent
import ir.amirroid.jetnews.common.components.PagingErrorButton
import ir.amirroid.jetnews.paging.state.LazyPagingSourceState


fun <T : Any> LazyListScope.handlePagingStates(
    state: LazyPagingSourceState<T>,
) {
    val loadState = state.loadState
    when (loadState.refresh) {
        is LoadState.Loading -> {
            item("loading-refresh") {
                Box(
                    Modifier.fillParentMaxSize(),
                ) {
                    LoadingContent()
                }
            }
        }

        is LoadState.Error -> {
            item("error-refresh") {
                Box(
                    Modifier.fillParentMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    PagingErrorButton(onRetry = state::refresh)
                }
            }
        }

        else -> Unit
    }

    when (loadState.append) {
        is LoadState.Loading -> {
            item("loading-append") {
                Box(
                    Modifier
                        .fillMaxWidth()
                        .padding(12.dp),
                    contentAlignment = Alignment.Center
                ) {
                    CircularProgressIndicator()
                }
            }
        }

        is LoadState.Error -> {
            item("error-append") {
                PagingErrorButton(onRetry = state::retry)
            }
        }

        else -> Unit
    }
}
