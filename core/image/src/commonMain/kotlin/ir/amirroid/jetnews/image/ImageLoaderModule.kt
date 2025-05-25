package ir.amirroid.jetnews.image

import coil3.ImageLoader
import coil3.PlatformContext
import coil3.network.ktor3.KtorNetworkFetcherFactory
import org.koin.dsl.module

val imageLoaderModule = module {
    factory { (context: PlatformContext) ->
        ImageLoader.Builder(context)
            .components {
                add(KtorNetworkFetcherFactory(httpClient = { get() }))
            }
            .build()
    }
}