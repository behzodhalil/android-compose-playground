package uz.behzoddev.a06_jetnotes_sample.screen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun NoteColorUi(
    modifier: Modifier = Modifier,
    size: Dp,
    color: Color,
    padding: Dp = 0.dp,
    border: Dp
) {
    Box(
        modifier = modifier
            .padding(padding)
            .size(size)
            .clip(CircleShape)
            .background(color)
            .border(
                BorderStroke(
                    border,
                    SolidColor(Color.Black)
                ), CircleShape
            )
    ) {
        /*Text(
            modifier = modifier.align(Alignment.Center),
            text = "Text",
            style = MaterialTheme.typography.body1,
            fontSize = 20.sp
        )*/
    }
}

@Preview(showBackground = true)
@Composable
fun NoteColorUiPreview() {
    NoteColorUi(
        size = 40.dp,
        color = Color.Yellow,
        padding = 8.dp,
        border = 2.dp
    )
}