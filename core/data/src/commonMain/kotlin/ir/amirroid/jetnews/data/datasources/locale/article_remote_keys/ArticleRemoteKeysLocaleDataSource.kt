package ir.amirroid.jetnews.data.datasources.locale.article_remote_keys

import ir.amirroid.jetnews.database.entities.ArticleRemoteKeyEntity

interface ArticleRemoteKeysLocaleDataSource {
    suspend fun getById(articleId: Int): ArticleRemoteKeyEntity?
    suspend fun clearAll()
    suspend fun upsertAll(keys: List<ArticleRemoteKeyEntity>)
}