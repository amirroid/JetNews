package ir.amirroid.jetnews.di.modules

import ir.amirroid.jetnews.data.datasources.locale.article.ArticleLocaleDatasource
import ir.amirroid.jetnews.data.datasources.locale.article.ArticleLocaleDatasourceImpl
import ir.amirroid.jetnews.data.datasources.locale.article_remote_keys.ArticleRemoteKeysLocaleDataSource
import ir.amirroid.jetnews.data.datasources.locale.article_remote_keys.ArticleRemoteKeysLocaleDataSourceImpl
import ir.amirroid.jetnews.data.datasources.remote.article.ArticleRemoteDataSource
import ir.amirroid.jetnews.data.datasources.remote.article.ArticleRemoteDataSourceImpl
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val datasourceModule = module {
    // Article
    singleOf(::ArticleRemoteDataSourceImpl).bind<ArticleRemoteDataSource>()
    singleOf(::ArticleLocaleDatasourceImpl).bind<ArticleLocaleDatasource>()

    // Remote Keys
    singleOf(::ArticleRemoteKeysLocaleDataSourceImpl).bind<ArticleRemoteKeysLocaleDataSource>()
}