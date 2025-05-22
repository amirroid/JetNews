package ir.amirroid.jetnews.di.modules

import ir.amirroid.jetnews.domain.usecases.article.FetchAllArticlesUseCase
import ir.amirroid.jetnews.domain.usecases.article.FetchSingleArticleUseCase
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

val useCasesModule = module {
    factoryOf(::FetchAllArticlesUseCase)
    factoryOf(::FetchSingleArticleUseCase)
}