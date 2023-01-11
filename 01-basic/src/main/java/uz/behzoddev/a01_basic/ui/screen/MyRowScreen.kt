package uz.behzoddev.a01_basic.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import uz.behzoddev.a01_basic.R
import uz.behzoddev.a01_basic.ui.theme.AndroidComposePlaygroundTheme

@Composable
fun MyRowScreen() {
    Row(
        modifier = Modifier.fillMaxSize(),
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically
    ) {
        MyRowTexts()
    }
}

@Composable
fun MyRowTexts() {
    val texts = listOf(
        R.string.row_one,
        R.string.row_two,
        R.string.row_three
    )

    texts.forEach { text ->
        Text(
            text = stringResource(id = text),
            color = Color.Black
        )
    }
}

@Preview
@Composable
fun MyRowPreview() {
    AndroidComposePlaygroundTheme {
        MyRowScreen()
    }
}