package ir.amirroid.jetnews.client

import io.ktor.client.HttpClient

interface PlatformHttpClientProvider {
    fun provide(): HttpClient
}

expect fun createHttpClientProvider(): PlatformHttpClientProvider