package uz.behzoddev.a02_thinking_in_compose.`01-basic`

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun MyComposableFunc(
    modifier: Modifier = Modifier,
    list: List<String> = listOf("Hello", "Behzod")
) {
    Column(modifier = modifier) {
        for (name in list) {
            Text(text = name)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MyComposableFuncPreview() {
    Surface(color = MaterialTheme.colors.primary, modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp)) {
        MyComposableFunc()
    }
}