package ir.amirroid.jetnews.data.network.services.comment

import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import ir.amirroid.jetnews.call.SafeApiCall
import ir.amirroid.jetnews.common.base.response.Response
import ir.amirroid.jetnews.data.models.comment.CommentResponse
import ir.amirroid.jetnews.response.NetworkErrors

class CommentApiServiceImpl(
    private val httpClient: HttpClient
) : CommentApiService {
    override suspend fun getCommentsForArticle(articleId: Int): Response<List<CommentResponse>, NetworkErrors> {
        return SafeApiCall.launch {
            httpClient.get(PATH_PREFIX) {
                parameter("a_id", articleId)
            }
        }
    }

    companion object {
        private const val PATH_PREFIX = "comments"
    }
}