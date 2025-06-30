package ir.amirroid.jetnews.utils

import kotlinx.serialization.Serializable

sealed interface AppPages {
    @Serializable
    data object NestedHome : AppPages {
        @Serializable
        data object Home : AppPages
    }

    @Serializable
    data class Article(val articleId: Int) : AppPages

    companion object {
        val startDestination: AppPages = NestedHome
    }
}