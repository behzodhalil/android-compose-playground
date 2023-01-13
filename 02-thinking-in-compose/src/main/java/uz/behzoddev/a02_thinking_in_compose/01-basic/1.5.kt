package uz.behzoddev.a02_thinking_in_compose.`01-basic`

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun MyLazyList(
    modifier: Modifier = Modifier,
    items: List<String> = List(1000) { "$it" }
) {

    LazyColumn(modifier = modifier.padding(4.dp)) {
        items(items) { name ->
            GreetingElevatedButton(name)
        }
    }
}