package ir.amirroid.jetnews

import androidx.compose.ui.window.ComposeUIViewController
import ir.amirroid.jetnews.di.startIosKoin

fun MainViewController() = ComposeUIViewController(
    configure = { startIosKoin() }
) { App() }