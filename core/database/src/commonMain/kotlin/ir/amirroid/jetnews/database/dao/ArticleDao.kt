package ir.amirroid.jetnews.database.dao

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Query
import androidx.room.RewriteQueriesToDropUnusedColumns
import androidx.room.Upsert
import ir.amirroid.jetnews.database.ARTICLES
import ir.amirroid.jetnews.database.entities.ArticleEntity

@Dao
interface ArticleDao {
    @RewriteQueriesToDropUnusedColumns
    @Query("SELECT DISTINCT * FROM $ARTICLES")
    fun getPagination(): PagingSource<Int, ArticleEntity>

    @Upsert
    suspend fun upsertAll(articles: List<ArticleEntity>)

    @Query("DELETE FROM $ARTICLES")
    suspend fun clear()
}