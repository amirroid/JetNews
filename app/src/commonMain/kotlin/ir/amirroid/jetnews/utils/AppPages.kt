package ir.amirroid.jetnews.utils

import kotlinx.serialization.Serializable

sealed interface AppPages {
    @Serializable
    data object Splash : AppPages

    @Serializable
    data object NestedHome : AppPages {
        data object Home : AppPages
    }


    companion object {
        val startDestination: AppPages = Splash
    }
}