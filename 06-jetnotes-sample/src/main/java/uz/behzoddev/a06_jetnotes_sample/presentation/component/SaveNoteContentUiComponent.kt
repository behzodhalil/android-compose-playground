package uz.behzoddev.a06_jetnotes_sample.presentation.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import uz.behzoddev.a06_jetnotes_sample.data.local.entity.NoteEntityModel

@Composable
fun SaveNoteContentUiComponent(
    modifier: Modifier = Modifier,
    note: NoteEntityModel,
    onNoteChange: (NoteEntityModel) -> Unit
) {
    Column(modifier = modifier.fillMaxSize()) {
        SaveNoteTextField(
            label = "Title",
            text = note.title,
            onTextChanged = { newTitle ->
                onNoteChange.invoke(note.copy(title = newTitle))
            }
        )

        SaveNoteTextField(
            modifier = modifier
                .heightIn(max = 240.dp)
                .padding(top = 16.dp),
            label = "Body",
            text = note.content,
            onTextChanged = { newContent ->
                onNoteChange.invoke(note.copy(title = newContent))
            }
        )

        val canBeCheckedOff: Boolean = note.isCheckedOff != null

        NoteCheckUiComponent(
            isChecked = canBeCheckedOff,
            onCheckedChange = { canBeCheckedOffNewValue ->
                val isCheckedOff: Boolean = !canBeCheckedOffNewValue

                onNoteChange.invoke(note.copy(isCheckedOff = isCheckedOff))
            })
    }
}

@Preview
@Composable
fun SaveNoteContentUiComponentPreview() {
    SaveNoteContentUiComponent(
        note = NoteEntityModel.DEFAULT_NOTE,
        onNoteChange = {}
    )
}