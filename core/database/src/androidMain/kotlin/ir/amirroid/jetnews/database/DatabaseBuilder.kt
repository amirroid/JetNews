package ir.amirroid.jetnews.database

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase

fun getDatabaseBuilder(context: Context): RoomDatabase.Builder<AppDatabase> {
    return Room.databaseBuilder(
        context = context.applicationContext,
        klass = AppDatabase::class.java,
        name = DATABASE_NAME
    )
}