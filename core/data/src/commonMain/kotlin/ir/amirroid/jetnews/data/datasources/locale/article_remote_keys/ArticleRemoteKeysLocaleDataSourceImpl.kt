package ir.amirroid.jetnews.data.datasources.locale.article_remote_keys

import ir.amirroid.jetnews.database.dao.ArticleRemoteKeyDao
import ir.amirroid.jetnews.database.entities.ArticleRemoteKeyEntity


class ArticleRemoteKeysLocaleDataSourceImpl(
    private val dao: ArticleRemoteKeyDao
) : ArticleRemoteKeysLocaleDataSource {
    override suspend fun getById(articleId: Int) = dao.getById(articleId)
    override suspend fun clearAll() = dao.clearAll()
    override suspend fun upsertAll(keys: List<ArticleRemoteKeyEntity>) = dao.upsertAll(keys)
}
