package ir.amirroid.jetnews.di.modules

import ir.amirroid.jetnews.data.paging.article.ArticleRemoteMediator
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val pagingModule = module {
    singleOf(::ArticleRemoteMediator)
}