package ir.amirroid.jetnews.data.network.services.article

import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import ir.amirroid.jetnews.call.SafeApiCall
import ir.amirroid.jetnews.common.base.response.Response
import ir.amirroid.jetnews.data.models.article.ArticleDetailResponse
import ir.amirroid.jetnews.data.models.article.ArticleResponse
import ir.amirroid.jetnews.data.network.services.article.ArticleApiService.Companion.PER_PAGE_COUNT
import ir.amirroid.jetnews.response.NetworkErrors

class ArticleApiServiceImpl(
    private val httpClient: HttpClient,
) : ArticleApiService {
    override suspend fun getAllArticles(page: Int): Response<List<ArticleResponse>, NetworkErrors> =
        SafeApiCall.launch {
            httpClient.get("${PATH_PREFIX}/latest") {
                parameter("per_page", PER_PAGE_COUNT)
                parameter("page", page)
            }
        }

    override suspend fun getArticle(articleId: Int): Response<ArticleDetailResponse, NetworkErrors> =
        SafeApiCall.launch {
            httpClient.get("$PATH_PREFIX/$articleId")
        }

    companion object {
        private const val PATH_PREFIX = "articles"
    }
}
