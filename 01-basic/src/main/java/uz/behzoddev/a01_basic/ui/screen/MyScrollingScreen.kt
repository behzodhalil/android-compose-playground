package uz.behzoddev.a01_basic.ui.screen

import android.util.Log
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import uz.behzoddev.a01_basic.R
import uz.behzoddev.a01_basic.ui.theme.AndroidComposePlaygroundTheme

@Composable
fun MyScrollingScreen(modifier: Modifier = Modifier) {
    MyScrolling(modifier)
}

@Composable
fun MyScrolling(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.verticalScroll(rememberScrollState())
    ) {
        BookImage(drawableId = R.drawable.kotlin, contentDescriptionId = R.string.column_one)
        BookImage(drawableId = R.drawable.kotlin, contentDescriptionId = R.string.column_one)
        BookImage(drawableId = R.drawable.kotlin, contentDescriptionId = R.string.column_one)

    }
}

@Composable
fun BookImage(@DrawableRes drawableId: Int, @StringRes contentDescriptionId: Int) {
    Image(
        bitmap = ImageBitmap.imageResource(id = drawableId),
        contentDescription = stringResource(id = contentDescriptionId),
        contentScale = ContentScale.FillBounds,
        modifier = Modifier.size(width = 100.dp, height = 100.dp)
    )
}

@Composable
@Preview
fun MyScrollingPreview() {
    AndroidComposePlaygroundTheme {
        MyScrollingScreen()
    }
}