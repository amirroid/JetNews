package ir.amirroid.jetnews.markdown

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.mikepenz.markdown.compose.MarkdownSuccess
import com.mikepenz.markdown.compose.components.MarkdownComponents
import com.mikepenz.markdown.model.State

@Composable
fun LazySuccessContent(
    state: State.Success,
    components: MarkdownComponents,
    modifier: Modifier = Modifier,
    paddingValues: PaddingValues = PaddingValues(),
    verticalArrangement: Arrangement.Vertical = Arrangement.Top,
    beforeMarkdownScope: LazyListScope.() -> Unit = {},
    afterMarkdownScope: LazyListScope.() -> Unit = {}
) {
    val lazyListState = rememberLazyListState()
    LazyColumn(
        state = lazyListState,
        contentPadding = paddingValues,
        verticalArrangement = verticalArrangement
    ) {
        beforeMarkdownScope.invoke(this)
        item("content") {
            MarkdownSuccess(state, components, modifier)
        }
        afterMarkdownScope.invoke(this)
    }
}
