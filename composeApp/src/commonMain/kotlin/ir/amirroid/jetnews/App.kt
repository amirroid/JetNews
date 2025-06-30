package ir.amirroid.jetnews

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import ir.amirroid.jetnews.common.state.ProvideAppState
import ir.amirroid.jetnews.navigation.MainNavigation
import ir.amirroid.jetnews.theme.ui.JetNewsTheme
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App() {
    ProvideAppState {
        JetNewsTheme {
            Scaffold {
                MainNavigation()
            }
        }
    }
}