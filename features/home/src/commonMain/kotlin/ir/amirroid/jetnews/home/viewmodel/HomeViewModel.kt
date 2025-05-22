package ir.amirroid.jetnews.home.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import androidx.paging.map
import ir.amirroid.jetnews.domain.usecases.article.FetchAllArticlesUseCase
import ir.amirroid.jetnews.home.mappers.toUiModel
import ir.amirroid.jetnews.home.models.ArticleUiModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map

class HomeViewModel(
    fetchAllArticlesUseCase: FetchAllArticlesUseCase,
    coroutineDispatcher: CoroutineDispatcher
) : ViewModel() {
    val articles: Flow<PagingData<ArticleUiModel>> = fetchAllArticlesUseCase()
        .map { pagingData ->
            pagingData.map { it.toUiModel() }
        }
        .flowOn(coroutineDispatcher)
        .cachedIn(viewModelScope)
}