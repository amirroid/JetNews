package ir.amirroid.jetnews.data.datasources.locale.article

import androidx.paging.PagingSource
import ir.amirroid.jetnews.database.entities.ArticleEntity

interface ArticleLocaleDatasource {
    fun getPagination(): PagingSource<Int, ArticleEntity>
    suspend fun upsertAll(articles: List<ArticleEntity>)
    suspend fun clearAll()
}