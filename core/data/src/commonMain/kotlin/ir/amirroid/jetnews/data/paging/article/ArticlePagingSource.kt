package ir.amirroid.jetnews.data.paging.article

import androidx.paging.PagingSource
import androidx.paging.PagingState
import ir.amirroid.jetnews.common.base.response.Response
import ir.amirroid.jetnews.data.datasources.remote.article.ArticleRemoteDataSource
import ir.amirroid.jetnews.data.models.article.ArticleResponse

class ArticlePagingSource(
    private val articleRemoteDataSource: ArticleRemoteDataSource
) : PagingSource<Int, ArticleResponse>() {

    override fun getRefreshKey(state: PagingState<Int, ArticleResponse>): Int? {
        return state.anchorPosition?.let { position ->
            state.closestPageToPosition(position)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(position)?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, ArticleResponse> {
        val currentPage = params.key ?: 1

        return when (val response = articleRemoteDataSource.getAllArticles(currentPage)) {
            is Response.Success -> {
                val data = response.data
                LoadResult.Page(
                    data = data,
                    prevKey = if (currentPage == 1) null else currentPage - 1,
                    nextKey = if (data.isEmpty()) null else currentPage + 1
                )
            }

            is Response.Error -> LoadResult.Error(Throwable(response.error.toString()))
            else -> LoadResult.Error(Throwable("Unexpected state"))
        }
    }
}