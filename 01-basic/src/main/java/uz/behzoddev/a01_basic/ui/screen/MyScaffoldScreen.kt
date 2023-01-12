package uz.behzoddev.a01_basic.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import uz.behzoddev.a01_basic.R
import uz.behzoddev.a01_basic.ui.theme.AndroidComposePlaygroundTheme
import uz.behzoddev.a01_basic.ui.theme.PrimaryColor

@Composable
fun MyScaffoldScreen() {
    MyScaffold()
}

@Composable
fun MyScaffold() {

    val scaffoldState = rememberScaffoldState()
    val scaffoldScope = rememberCoroutineScope()

    Scaffold(
        content = { MyRow() },
        topBar = { MyTopBar(state = scaffoldState, scope = scaffoldScope) },
        bottomBar = { MyBottomBar() },
        floatingActionButton = { MyFloatingActionButtonForScaffold() },
        floatingActionButtonPosition = FabPosition.End
    )
}

@Composable
fun MyDrawer() {

}

@Composable
fun MyTopBar(state: ScaffoldState, scope: CoroutineScope) {
    val drawerState = state.drawerState

    TopAppBar(
        navigationIcon = {
            IconButton(
                content = {
                    Icon(
                        Icons.Default.Menu,
                        tint = Color.White,
                        contentDescription = stringResource(id = R.string.top_bar_menu)
                    )
                },
                onClick = {
                    scope.launch {
                        if (drawerState.isClosed) drawerState.open() else drawerState.close()
                    }
                })
        },
        title = { Text(text = stringResource(id = R.string.app_name), color = Color.White) },
        backgroundColor = Color.Black
    )
}

@Composable
fun MyRow() {
    Row(
        modifier = Modifier.fillMaxSize(),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
    ) {
        val texts = listOf(
            R.string.row_one,
            R.string.row_two,
            R.string.row_three
        )

        texts.forEach { text ->
            Text(text = stringResource(id = text), color = PrimaryColor)
        }
    }
}

@Composable
fun MyBottomBar() {
    BottomAppBar(
        content = { MyBottomBarMenu() },
        backgroundColor = Color.Black
    )
}

@Composable
fun MyBottomBarMenu() {
    Row(
        modifier = Modifier.fillMaxSize(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        val texts = listOf(
            R.string.row_one,
            R.string.row_two,
            R.string.row_three
        )

        texts.forEach { text ->
            Text(text = stringResource(id = text), color = PrimaryColor)
        }
    }
}

@Composable
fun MyFloatingActionButtonForScaffold() {
    FloatingActionButton(
        onClick = { },
        shape = CircleShape,
        backgroundColor = PrimaryColor,
        contentColor = Color.Cyan
    ) {
        Icon(
            Icons.Default.Favorite,
            tint = Color.White,
            contentDescription = stringResource(id = R.string.top_bar_menu)
        )

    }
}

@Preview
@Composable
fun MyScaffoldPreview() {
    AndroidComposePlaygroundTheme {
        MyScaffoldScreen()
    }
}