package ir.amirroid.jetnews.article.viewmodel

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import ir.amirroid.jetnews.article.mappers.toUiModel
import ir.amirroid.jetnews.article.models.ArticleDetailUiModel
import ir.amirroid.jetnews.common.base.response.Response
import ir.amirroid.jetnews.common.base.response.map
import ir.amirroid.jetnews.domain.usecases.article.FetchSingleArticleUseCase
import ir.amirroid.jetnews.response.NetworkErrors
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class ArticleDetailViewModel(
    private val fetchSingleArticleUseCase: FetchSingleArticleUseCase,
    private val coroutineDispatcher: CoroutineDispatcher,
    savedStateHandle: SavedStateHandle
) : ViewModel() {
    private val _article =
        MutableStateFlow<Response<ArticleDetailUiModel, NetworkErrors>>(Response.Idle)
    val article: StateFlow<Response<ArticleDetailUiModel, NetworkErrors>> = _article

    private val articleId = savedStateHandle.get<Int>("articleId")!!

    init {
        fetchAllData()
    }

    private fun fetchAllData() = viewModelScope.launch(coroutineDispatcher) {
        _article.update { Response.Loading }
        val newResponse = fetchSingleArticleUseCase(articleId)
            .map { it.toUiModel() }
        _article.update { newResponse }
    }
}