package ir.amirroid.jetnews.date

import ir.amirroid.jetnews.date.formatter.DatetimeFormatter
import ir.amirroid.jetnews.date.parser.DatetimeParser
import kotlinx.datetime.Instant

val String.utcInstant: Instant
    get() = DatetimeParser.parseIsoInstant(this)

fun String.formatDayMonthWithOptionalYear() =
    DatetimeFormatter.formatDayMonthWithOptionalYear(utcInstant)