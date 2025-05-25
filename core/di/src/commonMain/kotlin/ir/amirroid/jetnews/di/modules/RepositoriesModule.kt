package ir.amirroid.jetnews.di.modules

import ir.amirroid.jetnews.data.repositories.article.ArticleRepositoryImpl
import ir.amirroid.jetnews.data.repositories.comment.CommentRepositoryImpl
import ir.amirroid.jetnews.domain.repositories.article.ArticleRepository
import ir.amirroid.jetnews.domain.repositories.comment.CommentRepository
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val repositoriesModule = module {
    singleOf(::ArticleRepositoryImpl).bind<ArticleRepository>()
    singleOf(::CommentRepositoryImpl).bind<CommentRepository>()
}