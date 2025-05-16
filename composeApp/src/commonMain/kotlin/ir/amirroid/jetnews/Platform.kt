package ir.amirroid.jetnews

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform