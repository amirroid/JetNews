package ir.amirroid.jetnews.di.modules

import ir.amirroid.jetnews.data.network.services.article.ArticleApiService
import ir.amirroid.jetnews.data.network.services.article.ArticleApiServiceImpl
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val apiServicesModule = module {
    singleOf(::ArticleApiServiceImpl).bind<ArticleApiService>()
}