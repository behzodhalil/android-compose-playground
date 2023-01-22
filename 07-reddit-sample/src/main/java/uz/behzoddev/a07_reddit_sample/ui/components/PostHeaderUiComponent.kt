package uz.behzoddev.a07_reddit_sample.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Composable
fun PostHeaderUiComponent(
    modifier: Modifier = Modifier
) {
    Row(modifier = modifier.padding(start = 16.dp)) {
        Image(
            imageVector = Icons.Filled.Call,
            contentDescription = "",
            modifier = modifier
                .size(40.dp)
                .clip(CircleShape)
        )

        Spacer(modifier = modifier.width(8.dp))

        Column(modifier = modifier.padding(end = 8.dp)) {
            Text(
                text = "r/meme",
                style = TextStyle(
                    fontWeight = FontWeight.Medium, color = Color.Black
                )
            )
            Text(
                text = "Posted by",
                style = TextStyle(
                    fontWeight = FontWeight.Light,
                    color = Color.Gray
                )

            )
        }
    }
}

@Composable
@Preview(showBackground = true)
fun PostHeaderUiPreviewComponent() {
    PostHeaderUiComponent()
}