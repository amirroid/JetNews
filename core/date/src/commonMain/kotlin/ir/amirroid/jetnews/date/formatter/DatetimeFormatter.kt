package ir.amirroid.jetnews.date.formatter

import ir.amirroid.jetnews.date.provider.TimeZoneProvider
import kotlinx.datetime.Clock
import kotlinx.datetime.Instant
import kotlinx.datetime.toLocalDateTime

object DatetimeFormatter : TimeZoneProvider() {
    fun formatDayMonthWithOptionalYear(instant: Instant): String {
        val localDateTime = instant.toLocalDateTime(systemTimeZone)
        val now = Clock.System.now().toLocalDateTime(systemTimeZone)

        val day = localDateTime.dayOfMonth
        val month = localDateTime.month.name.lowercase().replaceFirstChar { it.uppercaseChar() }

        return if (localDateTime.year == now.year) {
            "$day $month"
        } else {
            "$day $month ${localDateTime.year}"
        }
    }
}