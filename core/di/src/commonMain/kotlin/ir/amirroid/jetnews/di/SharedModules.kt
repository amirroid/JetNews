package ir.amirroid.jetnews.di

import ir.amirroid.jetnews.di.modules.apiServicesModule
import ir.amirroid.jetnews.di.modules.datasourceModule
import ir.amirroid.jetnews.di.modules.dispatchersModule
import ir.amirroid.jetnews.di.modules.repositoriesModule
import ir.amirroid.jetnews.di.modules.useCasesModule
import ir.amirroid.jetnews.di.modules.viewModelModules
import ir.amirroid.jetnews.image.imageLoaderModule

internal val sharedModules = listOf(
    networkModule,
    dispatchersModule,
    apiServicesModule,
    datasourceModule,
    repositoriesModule,
    useCasesModule,
    viewModelModules,
    imageLoaderModule
)