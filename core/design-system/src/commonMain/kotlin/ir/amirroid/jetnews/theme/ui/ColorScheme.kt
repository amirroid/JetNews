package ir.amirroid.jetnews.theme.ui

import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme

val LightColorScheme = lightColorScheme(
    primary = Blue,
    onPrimary = OnBlue,
    primaryContainer = LightBlue,
    onPrimaryContainer = OnLightBlue,

    secondary = Gray,
    onSecondary = OnGray,
    secondaryContainer = LightGray,
    onSecondaryContainer = OnLightGray,

    background = WhiteBackground,
    onBackground = OnWhiteBackground,

    surface = SurfaceLight,
    onSurface = OnSurfaceLight,

    error = Red,
    onError = OnRed
)

val DarkColorScheme = darkColorScheme(
    primary = SoftBlue,
    onPrimary = OnSoftBlue,
    primaryContainer = DarkBlue,
    onPrimaryContainer = OnDarkBlue,

    secondary = GrayLight,
    onSecondary = OnGrayLight,
    secondaryContainer = DarkGray,
    onSecondaryContainer = OnDarkGray,

    background = DarkBackground,
    onBackground = OnDarkBackground,

    surface = SurfaceDark,
    onSurface = OnSurfaceDark,

    error = RedDark,
    onError = OnRedDark
)