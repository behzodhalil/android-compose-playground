package uz.behzoddev.a07_reddit_sample.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun PostActionUiComponent(
    modifier: Modifier = Modifier,
    text: String,
    onClickAction: () -> Unit
) {
    Box(modifier = modifier.clickable { onClickAction() }) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(imageVector = Icons.Filled.Menu, contentDescription = "")
            Spacer(modifier = modifier.width(8.dp))
            Text(
                text = text,
                style = TextStyle(
                    color = Color.Gray,
                    fontWeight = FontWeight.Medium,
                    fontSize = 16.sp
                )
            )

        }
    }
}

@Composable
@Preview(showBackground = true)
fun PostActionUiPreviewComponent() {
    PostActionUiComponent(text = "Post Action") {

    }
}