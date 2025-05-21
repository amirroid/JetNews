package ir.amirroid.jetnews.home.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import ir.amirroid.jetnews.common.base.response.Response
import ir.amirroid.jetnews.common.base.response.map
import ir.amirroid.jetnews.common.base.response.mapList
import ir.amirroid.jetnews.common.state.ScreenState
import ir.amirroid.jetnews.domain.usecases.article.FetchAllArticlesUseCase
import ir.amirroid.jetnews.home.mappers.toUiModel
import ir.amirroid.jetnews.home.state.HomeState
import ir.amirroid.jetnews.response.NetworkErrors
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class HomeViewModel(
    private val fetchAllArticlesUseCase: FetchAllArticlesUseCase,
    private val coroutineDispatcher: CoroutineDispatcher
) : ViewModel() {
    private val _state = MutableStateFlow<ScreenState<HomeState, NetworkErrors>>(Response.Idle)
    val state: StateFlow<ScreenState<HomeState, NetworkErrors>> = _state

    init {
        fetchAllData()
    }

    private fun fetchAllData() = viewModelScope.launch(coroutineDispatcher) {
        _state.update { Response.Loading }
        val newArticles = fetchAllArticlesUseCase()
            .mapList { it.toUiModel() }
        val newState = newArticles
            .map {
                HomeState(
                    articles = it
                )
            }
        _state.update { newState }
    }
}