package uz.behzoddev.a01_basic.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.LinearProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import uz.behzoddev.a01_basic.ui.theme.AndroidComposePlaygroundTheme

@Composable
fun MyProgressBarScreen() {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
        ) {
            MyProgressBar()
    }
}

@Composable
fun MyProgressBar() {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        CircularProgressIndicator(
            color = Color.Magenta,
            strokeWidth = 5.dp
        )

        LinearProgressIndicator(
            modifier = Modifier.padding(top = 10.dp),
            color = Color.Black,
            progress = 1F
        )


    }
}

@Composable
@Preview
fun MyProgressBarPreview() {
    AndroidComposePlaygroundTheme {
        MyProgressBarScreen()
    }
}