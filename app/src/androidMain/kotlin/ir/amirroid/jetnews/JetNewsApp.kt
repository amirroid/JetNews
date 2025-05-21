package ir.amirroid.jetnews

import android.app.Application
import ir.amirroid.jetnews.di.startAndroidKoin

class JetNewsApp : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin()
    }

    private fun startKoin() {
        startAndroidKoin(applicationContext)
    }
}