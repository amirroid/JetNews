package ir.amirroid.jetnews.database.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import ir.amirroid.jetnews.database.ARTICLES_REMOTE_KEYS
import ir.amirroid.jetnews.database.entities.ArticleRemoteKeyEntity

@Dao
interface ArticleRemoteKeyDao {
    @Query("SELECT * FROM $ARTICLES_REMOTE_KEYS WHERE articleId = :id")
    suspend fun getById(id: Int): ArticleRemoteKeyEntity

    @Upsert
    suspend fun upsertAll(remoteKeys: List<ArticleRemoteKeyEntity>)

    @Query("DELETE FROM $ARTICLES_REMOTE_KEYS")
    suspend fun clearAll()
}