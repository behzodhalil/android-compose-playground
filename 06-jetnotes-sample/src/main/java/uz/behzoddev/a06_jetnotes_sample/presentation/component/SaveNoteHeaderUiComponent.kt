package uz.behzoddev.a06_jetnotes_sample.presentation.component

import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun SaveOrUpdateNoteHeaderComponent(
    isUpdateMode: Boolean,
    onBackClick: () -> Unit,
    onSaveNoteClick: () -> Unit,
    onOpenColorPickerClick: () -> Unit,
    onDeleteNoteClick: () -> Unit
) {
    TopAppBar(
        title = {
            SaveNoteHeaderTextUiComponent()
        },
        navigationIcon = {
            SaveNoteHeaderIconUiComponent(onBackClick)
        },
        actions = {
            SaveNoteHeaderCheckIconUiComponent(onSaveNoteClick)
            SaveNoteHeaderPickerIconUiComponent(onOpenColorPickerClick)
            SaveNoteHeaderDeleteIconUiComponent(
                isUpdateMode = isUpdateMode,
                onClick = onDeleteNoteClick
            )
        }
    )
}

@Composable
fun SaveNoteHeaderTextUiComponent() {
    Text(
        text = "Save Note",
        color = MaterialTheme.colors.onPrimary
    )
}

@Composable
fun SaveNoteHeaderIconUiComponent(onClick: () -> Unit) {
    IconButton(onClick = { onClick }) {
        Icon(
            imageVector = Icons.Default.ArrowBack,
            contentDescription = "Save Note Button",
            tint = MaterialTheme.colors.onPrimary
        )
    }
}

@Composable
fun SaveNoteHeaderCheckIconUiComponent(
    onClick: () -> Unit
) {
    IconButton(onClick = onClick) {
        Icon(
            imageVector = Icons.Default.Check,
            tint = MaterialTheme.colors.onPrimary,
            contentDescription = "Save note"
        )
    }
}

@Composable
fun SaveNoteHeaderPickerIconUiComponent(
    onClick: () -> Unit
) {
    IconButton(onClick = onClick) {
        Icon(
            imageVector = Icons.Filled.PlayArrow,
            tint = MaterialTheme.colors.onPrimary,
            contentDescription = "Save note"
        )
    }
}

@Composable
fun SaveNoteHeaderDeleteIconUiComponent(
    onClick: () -> Unit,
    isUpdateMode: Boolean
) {
    if (isUpdateMode) {
        IconButton(onClick = onClick) {
            Icon(
                imageVector = Icons.Default.Delete,
                contentDescription = "Delete Note Button",
                tint = MaterialTheme.colors.onPrimary
            )
        }
    }
}

@Composable
@Preview(showBackground = true)
fun SaveOrUpdateNoteHeaderComponentPreview() {
    SaveOrUpdateNoteHeaderComponent(
        isUpdateMode = false,
        onBackClick = {},
        onDeleteNoteClick = {},
        onSaveNoteClick = {},
        onOpenColorPickerClick = {}
    )
}