package ir.amirroid.jetnews.database.utils

import androidx.room.RoomDatabase

expect suspend fun <R> RoomDatabase.dbTransaction(block: suspend () -> R): R