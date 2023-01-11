package uz.behzoddev.a01_basic.ui.screen

import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.tooling.preview.Preview
import uz.behzoddev.a01_basic.ui.theme.AndroidComposePlaygroundTheme

@Composable
fun MyScaffoldScreen() {
}

@Composable
fun MyScaffold() {

    val scaffoldState = rememberScaffoldState()
    val scaffoldScope = rememberCoroutineScope()

    Scaffold(
      content = { MyRow()}
    )
}

@Composable
fun MyDrawer() {}

@Composable
fun MyTopBar() {}

@Composable
fun MyRow() {}

@Composable fun MyBottomBar() {}

@Preview
@Composable
fun MyScaffoldPreview() {
    AndroidComposePlaygroundTheme {
        MyScaffoldScreen()
    }
}