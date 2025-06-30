package ir.amirroid.jetnews.markdown

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun LazyMarkdown(
    content: String,
    modifier: Modifier = Modifier,
    itemsModifier: Modifier = Modifier,
    paddingValues: PaddingValues = PaddingValues(),
    verticalArrangement: Arrangement.Vertical = Arrangement.Top,
    beforeMarkdownScope: LazyListScope.() -> Unit = {},
    afterMarkdownScope: LazyListScope.() -> Unit = {}
) {
    CustomMarkdown(
        content = content,
        modifier = modifier,
        success = { state, components, modifier ->
            LazySuccessContent(
                state = state,
                components = components,
                modifier = modifier,
                itemsModifier = itemsModifier,
                paddingValues = paddingValues,
                verticalArrangement = verticalArrangement,
                beforeMarkdownScope = beforeMarkdownScope,
                afterMarkdownScope = afterMarkdownScope
            )
        },
    )
}