package ir.amirroid.jetnews.markdown

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.mikepenz.markdown.m3.Markdown
import com.mikepenz.markdown.model.ReferenceLinkHandlerImpl
import com.mikepenz.markdown.model.rememberMarkdownState
import ir.amirroid.jetnews.common.components.LoadingContent
import org.intellij.markdown.flavours.gfm.GFMFlavourDescriptor
import org.intellij.markdown.parser.MarkdownParser

@Composable
fun CustomMarkdown(
    content: String,
    modifier: Modifier = Modifier
) {
    val flavour = remember { GFMFlavourDescriptor() }
    val parser = remember {
        MarkdownParser(flavour)
    }
    val referenceLinkHandler = remember { ReferenceLinkHandlerImpl() }
    val markdownState = rememberMarkdownState(
        content = content,
        flavour = flavour,
        parser = parser,
        referenceLinkHandler = referenceLinkHandler
    )
    val state by markdownState.state.collectAsStateWithLifecycle()

    Markdown(
        state = state,
        modifier = modifier,
        imageTransformer = CoilImageTransformer,
        loading = {
            LoadingContent()
        }
    )
}