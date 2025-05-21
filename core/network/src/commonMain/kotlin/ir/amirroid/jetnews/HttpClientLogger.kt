package ir.amirroid.jetnews

import io.ktor.client.plugins.logging.Logger

object HttpClientLogger : Logger {
    private val logger = co.touchlab.kermit.Logger.withTag("HttpClientLogger")

    override fun log(message: String) {
        logger.d { message }
    }
}