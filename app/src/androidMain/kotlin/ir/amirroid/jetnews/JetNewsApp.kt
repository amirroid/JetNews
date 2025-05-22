package ir.amirroid.jetnews

import android.app.Application
import ir.amirroid.jetnews.di.startAndroidKoin
import ir.amirroid.jetnews.image.ImageLoaderConfiguration

class JetNewsApp : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin()
        ImageLoaderConfiguration.configure()
    }

    private fun startKoin() {
        startAndroidKoin(applicationContext)
    }
}