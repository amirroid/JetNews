package ir.amirroid.jetnews.domain.usecases.article

import androidx.paging.PagingData
import ir.amirroid.jetnews.domain.models.article.Article
import ir.amirroid.jetnews.domain.repositories.article.ArticleRepository
import kotlinx.coroutines.flow.Flow

class FetchAllArticlesUseCase(
    private val repository: ArticleRepository
) {
    operator fun invoke(): Flow<PagingData<Article>> {
        return repository.getAllArticles()
    }
}