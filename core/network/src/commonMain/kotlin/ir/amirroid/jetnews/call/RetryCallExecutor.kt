package ir.amirroid.jetnews.call

import ir.amirroid.jetnews.common.base.response.Response
import ir.amirroid.jetnews.common.base.response.onError
import ir.amirroid.jetnews.common.base.response.onSuccess
import ir.amirroid.jetnews.response.NetworkErrors

object RetryCallExecutor {
    suspend fun <D> call(
        times: Int = 3,
        block: suspend () -> Response<D, NetworkErrors>
    ): Response<D, NetworkErrors> {
        var currentAttempt = 0
        var lastData: Response<D, NetworkErrors> = Response.Loading

        while (currentAttempt < times) {
            val data = block()
            lastData = data.onSuccess {
                return Response.Success(it)
            }.onError {
                currentAttempt++
            }
        }

        return lastData
    }
}