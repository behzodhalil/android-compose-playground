package uz.behzoddev.a01_basic.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import uz.behzoddev.a01_basic.R
import uz.behzoddev.a01_basic.ui.theme.AndroidComposePlaygroundTheme

@Composable
fun MyColumnScreen() {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        MyColumn()
    }
}

@Composable
fun MyColumn() {
    val texts = listOf(
        R.string.column_one,
        R.string.column_two,
        R.string.column_three
    )

    texts.forEach { text ->
        Text(
            text = stringResource(id = text),
            fontSize = 20.sp
        )
    }
}

@Composable
@Preview
fun MyColumnPreview() {
    AndroidComposePlaygroundTheme {
        MyColumnScreen()
    }
}