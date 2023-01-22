package uz.behzoddev.a07_reddit_sample.ui.components

import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import uz.behzoddev.a07_reddit_sample.R

@Composable
fun ArrowButtonUiComponent(
    onClick: () -> Unit,
    arrowResourceId: ImageVector,
    modifier: Modifier = Modifier
) {
    IconButton(
        modifier = modifier.size(40.dp),
        onClick = { onClick() }
    ) {
        Icon(
            modifier = modifier.size(20.dp),
            imageVector = arrowResourceId ,
            contentDescription = "Arrow Button Ui Component",
            tint = Color.Gray
        )
    }
}

@Composable
@Preview(showBackground = true)
fun ArrowButtonUiPreviewComponent() {
    ArrowButtonUiComponent(
        onClick = { /*TODO*/ },
        arrowResourceId = Icons.Filled.ThumbUp
    )
}