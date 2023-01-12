package uz.behzoddev.a01_basic.ui.screen

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
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
fun MyListScreen() {
    MyList()
}

@Composable
fun MyList() {
    val books = listOf(
        BookCategory(
            R.drawable.kotlin,
            R.string.column_one
        ),
        BookCategory(
            R.drawable.kotlin,
            R.string.column_one
        ),
        BookCategory(
            R.drawable.kotlin,
            R.string.column_one
        ),
        BookCategory(
            R.drawable.kotlin,
            R.string.column_one
        )
    )
    LazyColumn {
        items(books) { item ->
            BookItem(bookCategory = item)
        }
    }
}

@Composable
fun BookItem(bookCategory: BookCategory, modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .padding(8.dp)
    ) {
        Image(
            modifier = modifier.size(width = 100.dp, height = 100.dp),
            bitmap = ImageBitmap.imageResource(id = bookCategory.resourceId),
            contentDescription = stringResource(id = bookCategory.contentDescId),
            contentScale = ContentScale.Fit
        )
    }
}


data class BookCategory(
    @DrawableRes val resourceId: Int,
    @StringRes val contentDescId: Int
)

@Composable
@Preview
fun MyLazyListPreview() {
    AndroidComposePlaygroundTheme {
        MyListScreen()
    }
}