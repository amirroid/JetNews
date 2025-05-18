package ir.amirroid.jetnews.client

import io.ktor.client.HttpClient
import io.ktor.client.engine.okhttp.OkHttp
import ir.amirroid.jetnews.API_RETRY_ON_CONNECTION_FAILURE

class AndroidHttpClientProvider : PlatformHttpClientProvider {
    override fun provide(): HttpClient {
        return HttpClient(OkHttp) {
            engine {
                config {
                    retryOnConnectionFailure(API_RETRY_ON_CONNECTION_FAILURE)
                }
            }
        }
    }
}

actual fun createHttpClientProvider(): PlatformHttpClientProvider {
    return AndroidHttpClientProvider()
}