package ir.amirroid.jetnews

import androidx.compose.ui.window.ComposeUIViewController
import ir.amirroid.jetnews.di.startIosKoin
import ir.amirroid.jetnews.image.ImageLoaderConfiguration

fun MainViewController() = ComposeUIViewController(
    configure = {
        startIosKoin()
        ImageLoaderConfiguration.configure()
    }
) { App() }