package ir.amirroid.jetnews.theme.locales

import androidx.compose.runtime.Composable
import androidx.compose.runtime.compositionLocalOf
import ir.amirroid.jetnews.theme.ui.ExtraShapes

val LocalExtraShapes = compositionLocalOf { ExtraShapes.Default }

val extraShapes: ExtraShapes
    @Composable
    get() = LocalExtraShapes.current