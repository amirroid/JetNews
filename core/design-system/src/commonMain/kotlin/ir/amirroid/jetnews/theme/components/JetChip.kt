package ir.amirroid.jetnews.theme.components

import androidx.compose.material3.AssistChip
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun JetAssistChip(
    onClick: () -> Unit,
    label: @Composable () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    leadingIcon: @Composable (() -> Unit)? = null,
    trailingIcon: @Composable (() -> Unit)? = null,
) {
    AssistChip(
        label = label,
        onClick = onClick,
        modifier = modifier,
        enabled = enabled,
        trailingIcon = trailingIcon,
        leadingIcon = leadingIcon
    )
}