package ir.amirroid.jetnews.database.di

import ir.amirroid.jetnews.database.getDatabaseBuilder
import org.koin.core.module.Module

actual fun Module.configureForPlatform() {
    single { getDatabaseBuilder() }
}