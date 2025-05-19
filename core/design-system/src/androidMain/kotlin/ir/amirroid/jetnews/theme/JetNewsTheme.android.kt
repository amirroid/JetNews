package ir.amirroid.jetnews.theme

import android.os.Build
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable

@Composable
actual fun JetNewsTheme(
    isDarkMode: Boolean,
    content: @Composable () -> Unit
) {
    val colorSchema = when {
        Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> rememberDynamicColorsSchema(isDarkMode)
        else -> MaterialTheme.colorScheme
    }

    MaterialTheme(
        colorScheme = colorSchema,
        content = content
    )
}