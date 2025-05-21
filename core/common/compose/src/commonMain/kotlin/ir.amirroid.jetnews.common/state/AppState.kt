package ir.amirroid.jetnews.common.state

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.Stable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import kotlinx.coroutines.CoroutineScope

@Stable
data class AppState(
    val navController: NavHostController,
    val scope: CoroutineScope
)

@Composable
fun rememberAppState(
    navController: NavHostController = rememberNavController(),
    scope: CoroutineScope = rememberCoroutineScope()
): AppState {
    return remember(navController, scope) {
        AppState(navController, scope)
    }
}

val LocalAppState = staticCompositionLocalOf<AppState> {
    error("AppState not provided yet")
}

@Composable
fun ProvideAppState(content: @Composable () -> Unit) {
    val appState = rememberAppState()
    CompositionLocalProvider(LocalAppState provides appState, content = content)
}