package ir.amirroid.jetnews.common.base.formatters

fun Int.formatWithThousandsSeparator(): String {
    return toString()
        .reversed()
        .chunked(3)
        .joinToString(",")
        .reversed()
}