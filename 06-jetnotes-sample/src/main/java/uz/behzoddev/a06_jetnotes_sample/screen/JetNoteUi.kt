package uz.behzoddev.a06_jetnotes_sample.screen

import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.tooling.preview.Preview
import kotlinx.coroutines.launch
import uz.behzoddev.a06_jetnotes_sample.core_ui.theme.AndroidComposePlaygroundTheme
import uz.behzoddev.a06_jetnotes_sample.data.local.entity.NoteEntityModel
import uz.behzoddev.a06_jetnotes_sample.presentation.component.NotesUiComponent

@Composable
fun JetNoteUi() {
    AndroidComposePlaygroundTheme {
        val coroutineScope = rememberCoroutineScope()
        val scaffoldState = rememberScaffoldState()

        Scaffold(
            scaffoldState = scaffoldState,
            drawerContent = {
                AppDrawerUi(
                    currentScreen = Screen.Home,
                    closeDrawerAction = {
                        coroutineScope.launch {
                            scaffoldState.drawerState.close()
                        }
                    }
                )
            },
            content = {
                NotesUiComponent(notes = listOf(
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
                    )),
                    onNoteCheckedChange = {}, onNoteClick = {})
            }
        )
    }
}

@Composable
@Preview(showBackground = true)
fun JetNoteUiPreview() {
    JetNoteUi()
}