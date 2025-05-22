package ir.amirroid.jetnews.database.di

import androidx.room.RoomDatabase
import androidx.sqlite.SQLiteDriver
import androidx.sqlite.driver.bundled.BundledSQLiteDriver
import ir.amirroid.jetnews.database.AppDatabase
import kotlinx.coroutines.CoroutineDispatcher
import org.koin.dsl.bind
import org.koin.dsl.module

val databaseModule = module {
    configureForPlatform()

    single { BundledSQLiteDriver() }.bind<SQLiteDriver>()

    single {
        get<RoomDatabase.Builder<AppDatabase>>()
            .setQueryCoroutineContext(get<CoroutineDispatcher>())
            .setDriver(get())
            .build()
    }

    single {
        get<AppDatabase>().articleDao()
    }
}