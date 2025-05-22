package ir.amirroid.jetnews.domain.repositories.article

import androidx.paging.PagingData
import ir.amirroid.jetnews.domain.models.article.Article
import kotlinx.coroutines.flow.Flow

interface ArticleRepository {
    fun getAllArticles(): Flow<PagingData<Article>>
}