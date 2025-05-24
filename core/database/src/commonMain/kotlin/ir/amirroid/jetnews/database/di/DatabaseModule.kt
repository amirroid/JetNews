package ir.amirroid.jetnews.database.di

import androidx.room.RoomDatabase
import androidx.sqlite.SQLiteDriver
import androidx.sqlite.driver.bundled.BundledSQLiteDriver
import ir.amirroid.jetnews.database.AppDatabase
import ir.amirroid.jetnews.database.dao.ArticleDao
import kotlinx.coroutines.CoroutineDispatcher
import org.koin.dsl.bind
import org.koin.dsl.module

val databaseModule = module {
    includes(platformModule)

    single<SQLiteDriver> { BundledSQLiteDriver() }.bind<SQLiteDriver>()

    single<AppDatabase> {
        get<RoomDatabase.Builder<AppDatabase>>()
            .setQueryCoroutineContext(get<CoroutineDispatcher>())
            .setDriver(get())
            .build()
    }

    single {
        get<AppDatabase>().articleDao()
    }

    single {
        get<AppDatabase>().articleRemoteKeysDao()
    }
}