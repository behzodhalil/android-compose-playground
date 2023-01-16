package uz.behzoddev.a06_jetnotes_sample.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Checkbox
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun NoteUi(modifier: Modifier = Modifier) {
    Row(modifier = modifier.fillMaxWidth()) {
        NoteColorUi(
            modifier = modifier.align(Alignment.CenterVertically),
            size = 40.dp,
            color = Color.Yellow,
            border = 2.dp
        )

        Column(
            modifier = modifier
                .weight(1F)
                .padding(start = 8.dp)
        ) {
            Text(text = "Title", maxLines = 1)
            Text(text = "Description", maxLines = 1)
        }

        Checkbox(
            modifier = modifier.padding(8.dp),
            checked = false,
            onCheckedChange = {}
        )
    }
}

@Composable
@Preview(showBackground = true)
fun NoteUiPreview() {
    NoteUi()
}