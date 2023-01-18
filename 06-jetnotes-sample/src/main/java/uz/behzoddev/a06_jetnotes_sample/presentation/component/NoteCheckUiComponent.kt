package uz.behzoddev.a06_jetnotes_sample.presentation.component

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Switch
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun NoteCheckUiComponent(
    modifier: Modifier = Modifier,
    isChecked: Boolean,
    onCheckedChange: (Boolean) -> Unit
) {
    Row(
        modifier = modifier
            .padding(8.dp)
            .padding(top = 16.dp)
    ) {
        Text(
            text = "Can note be checked off?",
            modifier = modifier.weight(1F)
        )

        Switch(
            modifier = modifier.padding(start = 8.dp),
            checked = isChecked,
            onCheckedChange =onCheckedChange
        )
    }
}

@Composable
@Preview(showBackground = true)
fun NoteCheckUiComponentPreview() {
    NoteCheckUiComponent(
        isChecked = false,
        onCheckedChange = {})
}
