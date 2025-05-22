package ir.amirroid.jetnews.database.dao

import androidx.room.Dao
import androidx.room.Query
import ir.amirroid.jetnews.database.ARTICLES
import ir.amirroid.jetnews.database.entities.ArticleEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface ArticleDao {
    @Query("SELECT * FROM $ARTICLES")
    suspend fun getAll(): Flow<List<ArticleEntity>>
}