package ir.amirroid.jetnews.data.extensions

import app.cash.paging.PagingData
import app.cash.paging.filter

fun <T : Any, K : Any> PagingData<T>.removeDuplicatesBy(keySelector: (T) -> K): PagingData<T> {
    val seenKeys = mutableSetOf<K>()
    return this.filter { item ->
        val key = keySelector(item)
        if (seenKeys.contains(key)) {
            false
        } else {
            seenKeys.add(key)
            true
        }
    }
}