package uz.behzoddev.a06_jetnotes_sample.presentation.screen

import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import kotlinx.coroutines.launch
import uz.behzoddev.a06_jetnotes_sample.core_ui.theme.AndroidComposePlaygroundTheme
import uz.behzoddev.a06_jetnotes_sample.data.local.entity.NoteEntityModel
import uz.behzoddev.a06_jetnotes_sample.presentation.component.NoteHeaderUiComponent
import uz.behzoddev.a06_jetnotes_sample.presentation.component.NotesUiComponent
import uz.behzoddev.a06_jetnotes_sample.screen.AppDrawerUi
import uz.behzoddev.a06_jetnotes_sample.screen.Screen

@Composable
fun NoteScreen() {
    AndroidComposePlaygroundTheme {
        val scaffoldState = rememberScaffoldState()
        val coroutineScope = rememberCoroutineScope()

        Scaffold(
            scaffoldState = scaffoldState,
            topBar = {
                NoteHeaderUiComponent(onIconClick = {
                    coroutineScope.launch {
                        scaffoldState.drawerState.open()
                    }
                })
            },
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
                    onNoteCheckedChange = {}, onNoteClick = {})
            },
            floatingActionButtonPosition = FabPosition.End,
            floatingActionButton = {
                FloatingActionButton(
                    backgroundColor = Color.Magenta,
                    contentColor = MaterialTheme.colors.onSurface,
                    content = {
                        Icon(
                            imageVector = Icons.Filled.Add,
                            contentDescription = "Add Floating Action Button"
                        )
                    },
                    onClick = { /*TODO*/ })
            }
        )
    }
}

@Composable
@Preview(showBackground = true)
fun NoteScreenPreview() {
    NoteScreen()
}