package ir.amirroid.jetnews.utils

import kotlinx.serialization.Serializable

sealed interface AppPages {
    @Serializable
    data object Splash : AppPages

    @Serializable
    data object NestedHome : AppPages {
        @Serializable
        data object Home : AppPages
    }


    companion object {
        val startDestination: AppPages = NestedHome
    }
}