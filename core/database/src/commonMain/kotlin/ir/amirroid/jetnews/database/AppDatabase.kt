package ir.amirroid.jetnews.database

import androidx.room.ConstructedBy
import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.RoomDatabaseConstructor
import ir.amirroid.jetnews.database.dao.ArticleDao
import ir.amirroid.jetnews.database.entities.ArticleEntity

@Database(
    version = DATABASE_VERSION,
    entities = [ArticleEntity::class]
)
@ConstructedBy(AppDatabaseConstructor::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun articleDao(): ArticleDao
}


@Suppress("NO_ACTUAL_FOR_EXPECT")
expect object AppDatabaseConstructor : RoomDatabaseConstructor<AppDatabase> {
    override fun initialize(): AppDatabase
}