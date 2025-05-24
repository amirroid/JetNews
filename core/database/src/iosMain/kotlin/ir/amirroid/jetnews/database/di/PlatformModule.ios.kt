package ir.amirroid.jetnews.database.di

import androidx.room.RoomDatabase
import ir.amirroid.jetnews.database.AppDatabase
import ir.amirroid.jetnews.database.getDatabaseBuilder
import org.koin.dsl.module

internal actual val platformModule = module {
    single<RoomDatabase.Builder<AppDatabase>> { getDatabaseBuilder() }
}