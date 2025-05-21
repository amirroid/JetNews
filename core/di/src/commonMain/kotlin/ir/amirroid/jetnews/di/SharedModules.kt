package ir.amirroid.jetnews.di

import ir.amirroid.jetnews.di.modules.datasourceModule
import ir.amirroid.jetnews.di.modules.dispatchersModule
import ir.amirroid.jetnews.di.modules.repositoriesModule
import ir.amirroid.jetnews.di.modules.useCasesModule

internal val sharedModules = listOf(
    networkModule,
    useCasesModule,
    datasourceModule,
    repositoriesModule,
    dispatchersModule
)