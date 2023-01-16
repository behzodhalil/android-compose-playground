package uz.behzoddev.a06_jetnotes_sample.screen

import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import kotlinx.coroutines.launch
import uz.behzoddev.a06_jetnotes_sample.`core-ui`.theme.AndroidComposePlaygroundTheme

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
            content = { NoteUi() }
        )
    }
}

@Composable
@Preview(showBackground = true)
fun JetNoteUiPreview() {
    JetNoteUi()
}