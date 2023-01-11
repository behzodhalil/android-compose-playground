package uz.behzoddev.a01_basic.ui.screen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import uz.behzoddev.a01_basic.R
import uz.behzoddev.a01_basic.ui.theme.AndroidComposePlaygroundTheme


@Composable
fun MySurfaceScreen(modifier: Modifier = Modifier) {
    Box(modifier = modifier.fillMaxSize()) {
        MySurface(modifier = modifier.align(Alignment.Center))
    }
}

@Composable
fun MySurface(modifier: Modifier) {
    Surface(
        modifier = modifier.size(100.dp),
        color = Color.Red,
        contentColor = colorResource(id = R.color.teal_700),
        elevation = 1.dp,
        border = BorderStroke(width = 1.dp, Color.Black)
    )
    {
        MyColumnTextsForSurface()
    }
}

@Composable
fun MyColumnTextsForSurface() {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        val list = listOf(
            R.string.column_one,
            R.string.column_two,
            R.string.column_three
        )

        list.forEach { text ->
            Text(
                text = stringResource(id = text),
                color = Color.Yellow,
                fontSize = 14.sp
            )
        }
    }
}


@Preview
@Composable
fun MySurfacePreview() {
    AndroidComposePlaygroundTheme {
        MySurfaceScreen()
    }
}