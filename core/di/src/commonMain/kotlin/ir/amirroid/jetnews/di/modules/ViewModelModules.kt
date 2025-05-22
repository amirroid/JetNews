package ir.amirroid.jetnews.di.modules

import ir.amirroid.jetnews.home.viewmodel.HomeViewModel
import ir.amirroid.jetnews.article.viewmodel.ArticleDetailViewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val viewModelModules = module {
    viewModelOf(::HomeViewModel)
    viewModelOf(::ArticleDetailViewModel)
}