package ir.amirroid.jetnews.navigation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import ir.amirroid.jetnews.common.state.LocalAppState
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
            Box(
                Modifier.fillMaxSize().background(MaterialTheme.colorScheme.background),
                contentAlignment = Alignment.Center
            ) {
                Button(onClick = {}) {
                    Text(
                        "Hello",
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Black
                    )
                }
            }
        }
    }
}