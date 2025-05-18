package ir.amirroid.jetnews.client

import io.ktor.client.HttpClient
import io.ktor.client.engine.okhttp.OkHttp

class AndroidHttpClientProvider : PlatformHttpClientProvider {
    override fun provide(): HttpClient {
        return HttpClient(OkHttp) {}
    }
}

actual fun createHttpClientProvider(): PlatformHttpClientProvider {
    return AndroidHttpClientProvider()
}