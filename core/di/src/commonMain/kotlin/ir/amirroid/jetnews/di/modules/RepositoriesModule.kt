package ir.amirroid.jetnews.di.modules

import ir.amirroid.jetnews.data.repositories.article.ArticleRepository
import ir.amirroid.jetnews.data.repositories.article.ArticleRepositoryImpl
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val repositoriesModule = module {
    singleOf(::ArticleRepositoryImpl).bind<ArticleRepository>()
}