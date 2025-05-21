package ir.amirroid.jetnews.theme.ui

import android.os.Build
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import ir.amirroid.jetnews.theme.USE_DYNAMIC_COLOR_SCHEME

@Composable
actual fun JetNewsTheme(
    isDarkMode: Boolean,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        Build.VERSION.SDK_INT >= Build.VERSION_CODES.S && USE_DYNAMIC_COLOR_SCHEME -> {
            rememberDynamicColorsScheme(
                isDarkMode
            )
        }

        else -> if (isDarkMode) DarkColorScheme else LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        content = content
    )
}