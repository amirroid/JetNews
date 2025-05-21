package ir.amirroid.jetnews.di

import io.ktor.client.HttpClient
import io.ktor.client.HttpClientConfig
import io.ktor.client.plugins.HttpTimeout
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.request.get
import io.ktor.client.statement.bodyAsText
import io.ktor.http.ContentType
import io.ktor.http.contentType
import io.ktor.serialization.kotlinx.json.json
import ir.amirroid.jetnews.API_CONNECT_TIMEOUT_SECONDS
import ir.amirroid.jetnews.API_REQUEST_TIMEOUT_MILLIS
import ir.amirroid.jetnews.API_SOCKET_TIMEOUT_SECONDS
import ir.amirroid.jetnews.HttpClientLogger
import ir.amirroid.jetnews.client.createHttpClientProvider
import ir.amirroid.jetnews.config.BuildConfig
import ir.amirroid.jetnews.qualifiers.BaseUrlQualifier
import kotlinx.serialization.json.Json
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val networkModule = module {
    factory(BaseUrlQualifier) { BuildConfig.BASE_URL }
    singleOf(::createJson)
    single {
        createConfiguredClient(get(BaseUrlQualifier), get())
    }
}

private fun HttpClientConfig<*>.configureLogging() {
    install(Logging) {
        level = LogLevel.BODY
        logger = HttpClientLogger
    }
}

private fun HttpClientConfig<*>.configureContentNegotiation(json: Json) {
    install(ContentNegotiation) {
        json(json)
    }
}

private fun HttpClientConfig<*>.configureTimeout() {
    install(HttpTimeout) {
        requestTimeoutMillis = API_REQUEST_TIMEOUT_MILLIS
        connectTimeoutMillis = API_CONNECT_TIMEOUT_SECONDS
        socketTimeoutMillis = API_SOCKET_TIMEOUT_SECONDS
    }
}


private fun HttpClientConfig<*>.configureDefaultRequest(
    baseUrl: String
) {
    defaultRequest {
        url(baseUrl)
        contentType(ContentType.Application.Json)
    }
}

private fun createConfiguredClient(
    baseUrl: String,
    json: Json
): HttpClient {
    return createHttpClientProvider().provide().config {
        configureLogging()
        configureContentNegotiation(json)
        configureTimeout()
        configureDefaultRequest(baseUrl)
    }
}

private fun createJson() = Json {
    isLenient = true
    explicitNulls = true
    prettyPrint = true
    ignoreUnknownKeys = true
    coerceInputValues = true
    encodeDefaults = true
}