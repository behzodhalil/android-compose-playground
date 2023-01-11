package uz.behzoddev.a01_basic.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import uz.behzoddev.a01_basic.R
import uz.behzoddev.a01_basic.ui.theme.AndroidComposePlaygroundTheme
import uz.behzoddev.a01_basic.ui.theme.Purple500
import uz.behzoddev.a01_basic.ui.theme.Teal200

@Composable
fun MyTextScreen() {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        MyText()
        MyTextWithFont()
        MyTextWithFontSize()
        MyTextWithFontWeight()
    }
}

@Composable
private fun MyText() {
    Text(
        text = stringResource(id = R.string.my_text),
        color = Teal200
    )
}

@Composable
private fun MyTextWithFont() {
    Text(
        text = stringResource(id = R.string.my_text),
        fontStyle = FontStyle.Italic,
        color = Teal200
    )
}

@Composable
private fun MyTextWithFontSize() {
    Text(
        text = stringResource(id = R.string.my_text),
        fontStyle = FontStyle.Normal,
        fontSize = 30.sp,
        color = Teal200
    )
}

@Composable
private fun MyTextWithFontWeight() {
    Text(
        text = stringResource(id = R.string.my_text),
        fontWeight = FontWeight.Bold,
        fontSize = 30.sp,
        color = Teal200
    )
}

@Preview
@Composable
fun MyTextPreview() {
    AndroidComposePlaygroundTheme {
        MyTextScreen()
    }
}