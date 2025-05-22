package ir.amirroid.jetnews.date.parser

import kotlinx.datetime.Instant

object DatetimeParser {
    fun parseIsoInstant(datetime: String): Instant {
        return try {
            Instant.parse(datetime)
        } catch (e: Exception) {
            throw IllegalArgumentException("Invalid datetime format: $datetime", e)
        }
    }
}