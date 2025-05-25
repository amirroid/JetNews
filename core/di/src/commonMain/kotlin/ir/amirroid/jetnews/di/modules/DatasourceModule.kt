package ir.amirroid.jetnews.di.modules

import ir.amirroid.jetnews.data.datasources.remote.article.ArticleRemoteDataSource
import ir.amirroid.jetnews.data.datasources.remote.article.ArticleRemoteDataSourceImpl
import ir.amirroid.jetnews.data.datasources.remote.comment.CommentRemoteDataSource
import ir.amirroid.jetnews.data.datasources.remote.comment.CommentRemoteDataSourceImpl
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val datasourceModule = module {
    // Article
    singleOf(::ArticleRemoteDataSourceImpl).bind<ArticleRemoteDataSource>()

    singleOf(::CommentRemoteDataSourceImpl).bind<CommentRemoteDataSource>()
}