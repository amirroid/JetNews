package ir.amirroid.jetnews.theme.ui

import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.dp
import com.riadmahi.proshape.ProShape

@Immutable
data class ExtraShapes(
    val small: Shape,
    val medium: Shape,
    val large: Shape
) {
    companion object {
        val Default = ExtraShapes(
            small = ProShape.rounded(4.dp),
            medium = ProShape.rounded(16.dp),
            large = ProShape.rounded(24.dp),
        )
    }
}