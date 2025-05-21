package ir.amirroid.jetnews.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import ir.amirroid.jetnews.common.state.LocalAppState
import ir.amirroid.jetnews.home.screen.HomeScreen
import ir.amirroid.jetnews.utils.AppPages

@Composable
fun MainNavigation() {
    val appState = LocalAppState.current
    val navController = appState.navController

    NavHost(
        navController = navController,
        startDestination = AppPages.startDestination
    ) {
        composable<AppPages.Splash> {
        }
        buildNestedHome()
    }
}


fun NavGraphBuilder.buildNestedHome() {
    navigation<AppPages.NestedHome>(
        startDestination = AppPages.NestedHome.Home
    ) {
        composable<AppPages.NestedHome.Home> {
            HomeScreen()
        }
    }
}