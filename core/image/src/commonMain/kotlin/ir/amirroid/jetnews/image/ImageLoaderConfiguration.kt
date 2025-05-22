package ir.amirroid.jetnews.image

import coil3.SingletonImageLoader
import org.koin.core.component.KoinComponent
import org.koin.core.component.get
import org.koin.core.parameter.parametersOf

object ImageLoaderConfiguration : KoinComponent {
    fun configure() {
        SingletonImageLoader.setSafe { context ->
            get { parametersOf(context) }
        }
    }
}