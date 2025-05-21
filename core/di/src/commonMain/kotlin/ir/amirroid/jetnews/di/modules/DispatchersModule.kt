package ir.amirroid.jetnews.di.modules

import ir.amirroid.jetnews.di.qualifiers.IODispatcher
import ir.amirroid.jetnews.di.qualifiers.MainDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import org.koin.dsl.module

val dispatchersModule = module {
    single(IODispatcher) { Dispatchers.IO }
    single(MainDispatcher) { Dispatchers.Main }
}