package ir.amirroid.jetnews.paging.state

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberUpdatedState
import androidx.paging.PagingData
import app.cash.paging.compose.LazyPagingItems
import app.cash.paging.compose.collectAsLazyPagingItems
import app.cash.paging.compose.itemKey
import kotlinx.coroutines.flow.Flow

@Stable
class LazyPagingSourceState<T : Any>(
    private val lazyPagingItems: LazyPagingItems<T>
) {
    internal val loadState = lazyPagingItems.loadState
    val itemCount = lazyPagingItems.itemCount


    operator fun get(index: Int) = lazyPagingItems.itemSnapshotList.getOrNull(index)
    fun itemKey(key: ((item: T) -> Any)? = null) = lazyPagingItems.itemKey(key)
    fun retry() = lazyPagingItems.retry()
    fun refresh() = lazyPagingItems.refresh()
}

@Composable
fun <T : Any> Flow<PagingData<T>>.collectAsLazyPagingSourceState(): LazyPagingSourceState<T> {
    val state by rememberUpdatedState(collectAsLazyPagingItems())
    return remember(state.loadState) { LazyPagingSourceState(state) }
}