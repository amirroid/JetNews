package ir.amirroid.jetnews.di

import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.request.get
import io.ktor.client.statement.bodyAsText
import io.ktor.serialization.kotlinx.json.json
import ir.amirroid.jetnews.client.createHttpClientProvider
import kotlinx.serialization.json.Json
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val networkModule = module {
    singleOf(::createJson)
    singleOf(::createConfiguredClient)
}

private fun createConfiguredClient(
    json: Json
): HttpClient {
    return createHttpClientProvider().provide().config {
        install(Logging)
        install(ContentNegotiation) {
            json(json)
        }
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