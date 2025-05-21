package ir.amirroid.jetnews.theme.ui

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable

@Composable
actual fun JetNewsTheme(
    isDarkMode: Boolean,
    content: @Composable () -> Unit
) {
    val colorScheme = if (isDarkMode) DarkColorScheme else LightColorScheme
    MaterialTheme(
        content = content,
        colorScheme = colorScheme
    )
}