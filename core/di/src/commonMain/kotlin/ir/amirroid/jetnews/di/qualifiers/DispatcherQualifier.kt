package ir.amirroid.jetnews.di.qualifiers

import org.koin.core.qualifier.qualifier

val IODispatcher = qualifier("io-coroutines")
val MainDispatcher = qualifier("main-coroutines")