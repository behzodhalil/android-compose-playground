package uz.behzoddev.a01_basic.ui.screen

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import uz.behzoddev.a01_basic.R
import uz.behzoddev.a01_basic.ui.theme.AndroidComposePlaygroundTheme

@Composable
fun MyLazyRowListScreen() {
    Surface(modifier = Modifier.height(250.dp)) {
        MyLazyRowList()
    }
}

@Composable
fun MyLazyRowList() {
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

    LazyRow() {
        items(books) { book ->
            BookItem(bookCategory = book)
        }
    }
}


@Preview
@Composable
fun MyLazyRowPreview() {
    AndroidComposePlaygroundTheme {
        MyLazyRowListScreen()
    }
}