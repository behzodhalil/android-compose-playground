package uz.behzoddev.a06_jetnotes_sample.presentation.component

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import uz.behzoddev.a06_jetnotes_sample.data.local.entity.NoteEntityModel

@Composable
fun NotesUiComponent(
    notes: List<NoteEntityModel>,
    onNoteCheckedChange: (NoteEntityModel) -> Unit,
    onNoteClick: (NoteEntityModel) -> Unit
) {
    LazyColumn {
        items(count = notes.size) { noteIndex ->
            val note = notes[noteIndex]
            NoteUiComponent(
                note = note,
                onNoteCheckedChanged = onNoteCheckedChange,
                onNoteClick = onNoteClick
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun NotesUiComponentPreview() {
    NotesUiComponent(
        notes = listOf(
            NoteEntityModel(
                title = "Title #1",
                content = "Content",
                isCheckedOff = false,
                isInTrash = false,
                canBeCheckedOff = false,
                colorId = 1
            ),
            NoteEntityModel(
                title = "Title #2",
                content = "Content",
                isCheckedOff = true,
                isInTrash = false,
                canBeCheckedOff = false,
                colorId = 1
            ),
            NoteEntityModel(
                title = "Title #3",
                content = "Content",
                isCheckedOff = false,
                isInTrash = false,
                canBeCheckedOff = false,
                colorId = 1
            )

        ),
        onNoteCheckedChange = {},
        onNoteClick = {})
}