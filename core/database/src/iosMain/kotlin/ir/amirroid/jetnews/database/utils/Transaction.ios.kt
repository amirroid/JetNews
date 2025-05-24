package ir.amirroid.jetnews.database.utils

import androidx.room.RoomDatabase


actual suspend fun <R> RoomDatabase.dbTransaction(block: suspend () -> R): R {
    return block.invoke()
}