package ir.amirroid.jetnews.navigation

import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import ir.amirroid.jetnews.article.screen.ArticleDetailScreen
import ir.amirroid.jetnews.common.state.LocalAppState
import ir.amirroid.jetnews.home.screen.HomeScreen
import ir.amirroid.jetnews.utils.AppPages

@Composable
fun MainNavigation() {
    val appState = LocalAppState.current
    val navController = appState.navController

    NavHost(
        navController = navController,
        startDestination = AppPages.startDestination,
        enterTransition = {
            slideIntoContainer(AnimatedContentTransitionScope.SlideDirection.Left)
        },
        exitTransition = {
            ExitTransition.None
        },
        popEnterTransition = {
            EnterTransition.None
        },
        popExitTransition = {
            slideOutOfContainer(AnimatedContentTransitionScope.SlideDirection.Right)
        }
    ) {
        composable<AppPages.Article> {
            ArticleDetailScreen(onBackPress = navController::navigateUp)
        }
        buildNestedHome(navController)
    }
}


fun NavGraphBuilder.buildNestedHome(navController: NavHostController) {
    navigation<AppPages.NestedHome>(
        startDestination = AppPages.NestedHome.Home
    ) {
        composable<AppPages.NestedHome.Home> {
            HomeScreen(
                onClickArticles = {
                    navController.navigate(AppPages.Article(it))
                }
            )
        }
    }
}