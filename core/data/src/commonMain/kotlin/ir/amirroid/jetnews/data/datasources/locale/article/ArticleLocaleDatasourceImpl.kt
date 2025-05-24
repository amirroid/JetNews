package ir.amirroid.jetnews.data.datasources.locale.article

import androidx.paging.PagingSource
import ir.amirroid.jetnews.database.dao.ArticleDao
import ir.amirroid.jetnews.database.entities.ArticleEntity

class ArticleLocaleDatasourceImpl(private val articleDao: ArticleDao) : ArticleLocaleDatasource {
    override fun getPagination(): PagingSource<Int, ArticleEntity> {
        return articleDao.getPagination()
    }

    override suspend fun upsertAll(articles: List<ArticleEntity>) {
        return articleDao.upsertAll(articles)
    }

    override suspend fun clearAll() {
        return articleDao.clear()
    }
}