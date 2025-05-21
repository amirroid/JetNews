package ir.amirroid.jetnews.data.network.services.article

import io.ktor.client.HttpClient
import io.ktor.client.request.get
import ir.amirroid.jetnews.call.SafeApiCall
import ir.amirroid.jetnews.common.base.response.Response
import ir.amirroid.jetnews.data.models.article.ArticleResponse
import ir.amirroid.jetnews.response.NetworkErrors

class ArticleApiServiceImpl(private val httpClient: HttpClient) : ArticleApiService {
    override suspend fun getAllArticles(): Response<List<ArticleResponse>, NetworkErrors> {
        return SafeApiCall.launch {
            httpClient.get(PATH_PREFIX)
        }
    }

    companion object {
        private const val PATH_PREFIX = "articles"
    }
}