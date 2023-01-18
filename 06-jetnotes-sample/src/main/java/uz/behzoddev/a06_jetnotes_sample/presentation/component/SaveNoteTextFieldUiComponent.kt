package uz.behzoddev.a06_jetnotes_sample.presentation.component

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun SaveNoteTextField(
    modifier: Modifier = Modifier,
    label: String,
    text: String,
    onTextChanged: (String) -> Unit
) {
    TextField(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp),
        value = text,
        label = { Text(text = label)},
        onValueChange = onTextChanged,
        colors = TextFieldDefaults.textFieldColors(
            backgroundColor = MaterialTheme.colors.surface
        )
    )

}

@Composable
@Preview(showBackground = true)
fun SaveNoteTextFieldPreview() {
    SaveNoteTextField(
        label = "Enter a text",
        text = "",
        onTextChanged = {}
    )
}