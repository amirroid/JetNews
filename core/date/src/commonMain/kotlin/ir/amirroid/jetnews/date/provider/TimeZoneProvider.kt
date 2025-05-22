package ir.amirroid.jetnews.date.provider

import kotlinx.datetime.TimeZone

abstract class TimeZoneProvider {
    protected val systemTimeZone: TimeZone
        get() = TimeZone.currentSystemDefault()
}