package uz.behzoddev.a07_reddit_sample.ui.components

import androidx.compose.foundation.layout.Row
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp

@Composable
fun VotingActionUiComponent(
    text: String,
    onUpClick: () -> Unit,
    onDownClick: () -> Unit
) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        ArrowButtonUiComponent(
            onClick = { onUpClick() },
            arrowResourceId = Icons.Default.KeyboardArrowUp
        )

        Text(
            text = text,
            style = TextStyle(
                color = Color.Gray,
                fontSize = 12.sp,
                fontWeight = FontWeight.Medium
            )
        )

        ArrowButtonUiComponent(
            onClick = { onDownClick() },
            arrowResourceId = Icons.Filled.KeyboardArrowDown
        )
    }
}

@Composable
@Preview(showBackground = true)
fun VotingActionUiPreviewComponent() {
    VotingActionUiComponent(text = "555", onUpClick = {}, onDownClick = {})
}