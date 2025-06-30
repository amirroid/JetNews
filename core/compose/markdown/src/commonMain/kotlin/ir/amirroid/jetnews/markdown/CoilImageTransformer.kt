package ir.amirroid.jetnews.markdown

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.geometry.isUnspecified
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.Density
import coil3.compose.AsyncImagePainter
import coil3.compose.LocalPlatformContext
import coil3.compose.rememberAsyncImagePainter
import coil3.request.ImageRequest
import com.mikepenz.markdown.model.ImageData
import com.mikepenz.markdown.model.ImageTransformer
import com.mikepenz.markdown.model.PlaceholderConfig

internal object CoilImageTransformer : ImageTransformer {
    @Composable
    override fun transform(link: String): ImageData {
        return rememberAsyncImagePainter(
            contentScale = ContentScale.FillWidth,
            model = ImageRequest.Builder(LocalPlatformContext.current)
                .data(link)
                .size(coil3.size.Size.ORIGINAL)
                .build()
        ).let { painter ->
            ImageData(
                painter = painter,
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxWidth(),
                alignment = Alignment.Center
            )
        }
    }

    @Composable
    override fun intrinsicSize(painter: Painter): Size {
        var size by remember(painter) { mutableStateOf(painter.intrinsicSize) }
        if (painter is AsyncImagePainter) {
            val painterState = painter.state.collectAsState()
            val intrinsicPainterSize = painterState.value.painter?.intrinsicSize
            intrinsicPainterSize?.also { size = it }
        }
        return size
    }

    override fun placeholderConfig(
        density: Density,
        containerSize: Size,
        intrinsicImageSize: Size
    ): PlaceholderConfig {
        val fallbackSize = Size(400f, 400f)

        val targetSize = if (
            containerSize.isUnspecified ||
            intrinsicImageSize.isUnspecified ||
            intrinsicImageSize.width == 0f
        ) {
            fallbackSize
        } else {
            val aspectRatio = intrinsicImageSize.height / intrinsicImageSize.width
            val width = containerSize.width
            val height = width * aspectRatio
            Size(width, height)
        }

        val dpSize = with(density) { targetSize.toDpSize() }
        val finalSize = Size(dpSize.width.value, dpSize.height.value)

        return PlaceholderConfig(size = finalSize, animate = false)
    }
}