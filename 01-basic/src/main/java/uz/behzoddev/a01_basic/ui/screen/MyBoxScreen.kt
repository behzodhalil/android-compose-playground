package uz.behzoddev.a01_basic.ui.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import uz.behzoddev.a01_basic.R
import uz.behzoddev.a01_basic.ui.theme.AndroidComposePlaygroundTheme

@Composable
fun MyBoxScreen() {
    MyBox()
}

@Composable
fun MyBox(
    modifier: Modifier = Modifier,
    contentModifier: Modifier = Modifier
) {
    Box(
        modifier = modifier.fillMaxSize()
    ) {
        Text(
            text = stringResource(id = R.string.my_text),
            fontSize = 24.sp,
            modifier = contentModifier.align(Alignment.TopEnd)
        )

        Text(
            text = stringResource(id = R.string.my_text),
            fontSize = 24.sp,
            modifier =
            contentModifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 10.dp)
        )

        Text(
            text = stringResource(id = R.string.my_text),
            fontSize = 24.sp,
            modifier = contentModifier
                .align(Alignment.Center)
        )
    }
}

@Composable
@Preview
fun MyBoxPreview() {
    AndroidComposePlaygroundTheme {
        MyBoxScreen()
    }
}