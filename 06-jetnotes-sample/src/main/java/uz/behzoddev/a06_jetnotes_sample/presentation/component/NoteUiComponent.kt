package uz.behzoddev.a06_jetnotes_sample.presentation.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import uz.behzoddev.a06_jetnotes_sample.data.local.entity.NoteEntityModel
import uz.behzoddev.a06_jetnotes_sample.screen.NoteColorUi

@Composable
fun NoteUiComponent(
    modifier: Modifier = Modifier,
    note: NoteEntityModel,
    onNoteCheckedChanged: (NoteEntityModel) -> Unit = {},
    onNoteClick: (NoteEntityModel) -> Unit = {}
) {
    val backgroundShape = RoundedCornerShape(4.dp)
    Row(
        modifier = modifier
            .padding(8.dp)
            .shadow(1.dp, backgroundShape)
            .fillMaxWidth()
            .heightIn(min = 64.dp)
            .background(Color.White, backgroundShape)
            .clickable(onClick = { onNoteClick(note) })
    ) {
        NoteColorUi(
            modifier = modifier
                .align(Alignment.CenterVertically)
                .padding(start = 16.dp, end = 16.dp),
            size = 40.dp,
            color = Color.Magenta,
            border = 1.dp
        )

        Column(
            modifier = modifier
                .weight(1F)
                .align(Alignment.CenterVertically)
        ) {
            Text(
                text = note.title,
                color = Color.Black,
                maxLines = 1,
                style = TextStyle(
                    fontWeight = FontWeight.Normal,
                    fontSize = 16.sp,
                    letterSpacing = 0.15.sp
                )
            )

            Text(
                text = note.content,
                maxLines = 1,
                style = TextStyle(
                    color = Color.Black,
                    fontWeight = FontWeight.Light,
                    fontSize = 12.sp,
                    letterSpacing = 0.15.sp
                )
            )

        }

        Checkbox(
            modifier = modifier
                .padding(16.dp)
                .align(Alignment.CenterVertically),
            checked = note.isCheckedOff,
            onCheckedChange = { isChecked ->
                val newNote = note.copy(
                    isCheckedOff = isChecked
                )
            })
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun NoteWithCardUiComponent(
    modifier: Modifier = Modifier,
    note: NoteEntityModel,
    onNoteClick: (NoteEntityModel) -> Unit,
    onNoteCheckedRange: (NoteEntityModel) -> Unit,
    isSelected: Boolean
) {
    val background = if (isSelected)
        Color.LightGray
    else
        MaterialTheme.colors.surface

    val backgroundShape = RoundedCornerShape(4.dp)

    Card(
        modifier = modifier
            .padding(8.dp)
            .fillMaxWidth(),
        shape = backgroundShape,
        backgroundColor = background
    ) {
        ListItem(
            modifier = modifier.clickable { onNoteClick.invoke(note) },
            text = { Text(text = note.title, maxLines = 1) },
            secondaryText = {
                Text(text = note.content, maxLines = 1)
            },
            icon = {
                NoteColorUi(
                    size = 40.dp,
                    color = Color.Magenta,
                    border = 1.dp
                )
            },
            trailing = {
                Checkbox(
                    modifier = modifier.padding(start = 8.dp),
                    checked = note.isCheckedOff,
                    onCheckedChange = {})
            }
        )

    }
}

@Composable
@Preview(showBackground = true)
fun NoteUiComponentPreview() {
    /* NoteUiComponent(
         note = NoteEntityModel(
             title = "Note 1",
             content = "Content",
             canBeCheckedOff = false,
             colorId = 1,
             isCheckedOff = false,
             isInTrash = false
         )
     )*/

    NoteWithCardUiComponent(
        note = NoteEntityModel.DEFAULT_NOTE,
        onNoteClick = {},
        onNoteCheckedRange = {},
        isSelected = false
    )
}