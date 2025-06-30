package ir.amirroid.jetnews.article.viewmodel

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import ir.amirroid.jetnews.article.mappers.toUiModel
import ir.amirroid.jetnews.article.state.ArticleDetailScreenState
import ir.amirroid.jetnews.common.base.response.Response
import ir.amirroid.jetnews.common.base.response.combineResponses
import ir.amirroid.jetnews.common.base.response.map
import ir.amirroid.jetnews.common.base.response.mapList
import ir.amirroid.jetnews.common.state.ScreenState
import ir.amirroid.jetnews.domain.usecases.article.FetchSingleArticleUseCase
import ir.amirroid.jetnews.domain.usecases.comment.FetchAllArticleCommentsUseCase
import ir.amirroid.jetnews.response.NetworkErrors
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ArticleDetailViewModel(
    private val fetchSingleArticleUseCase: FetchSingleArticleUseCase,
    private val fetchAllArticleCommentsUseCase: FetchAllArticleCommentsUseCase,
    private val coroutineDispatcher: CoroutineDispatcher,
    savedStateHandle: SavedStateHandle
) : ViewModel() {
    private val _state =
        MutableStateFlow<ScreenState<ArticleDetailScreenState, NetworkErrors>>(Response.Idle)
    val state: StateFlow<ScreenState<ArticleDetailScreenState, NetworkErrors>> = _state

    private val articleId: Int = checkNotNull(savedStateHandle["articleId"]) {
        "articleId is required in SavedStateHandle"
    }

    init {
        fetchArticleDetail()
    }

    private fun fetchArticleDetail() {
        viewModelScope.launch(coroutineDispatcher) {
            _state.value = Response.Loading

            val articleDeferred =
                async { fetchSingleArticleUseCase(articleId).map { it.toUiModel() } }
            val commentsDeferred =
                async { fetchAllArticleCommentsUseCase(articleId).mapList { it.toUiModel() } }

            val articleResult = articleDeferred.await()
            val commentsResult = commentsDeferred.await()

            _state.value = combineResponses(articleResult, commentsResult) { article, comments ->
                ArticleDetailScreenState(article, comments)
            }
        }
    }

    fun retry() = fetchArticleDetail()
}