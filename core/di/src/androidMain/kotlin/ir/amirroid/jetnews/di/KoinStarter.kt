package ir.amirroid.jetnews.di

import android.content.Context
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

fun startAndroidKoin(context: Context) {
    startKoin {
        androidContext(context)
        modules(sharedModules)
    }
}