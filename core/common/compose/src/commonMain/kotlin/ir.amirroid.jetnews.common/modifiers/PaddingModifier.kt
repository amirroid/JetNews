package ir.amirroid.jetnews.common.modifiers

import androidx.compose.foundation.layout.padding
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

val horizontalPadding = 24.dp
val verticalPadding = 16.dp

fun Modifier.allPadding() = padding(horizontal = horizontalPadding, vertical = verticalPadding)

fun Modifier.horizontalPadding() = padding(horizontal = horizontalPadding)
fun Modifier.verticalPadding() = padding(vertical = verticalPadding)

fun Modifier.topPadding() = padding(top = verticalPadding)
fun Modifier.bottomPadding() = padding(bottom = verticalPadding)
fun Modifier.startPadding() = padding(start = horizontalPadding)
fun Modifier.endPadding() = padding(end = horizontalPadding)