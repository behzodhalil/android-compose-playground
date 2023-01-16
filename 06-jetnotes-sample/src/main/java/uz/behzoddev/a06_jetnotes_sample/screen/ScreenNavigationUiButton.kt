package uz.behzoddev.a06_jetnotes_sample.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun ScreenNavigationUiButton(
    modifier: Modifier = Modifier,
    icon: ImageVector,
    label: String,
    isSelected: Boolean,
    onClick: () -> Unit
) {
    val colors = MaterialTheme.colors

    val imageAlpha = if (isSelected) 1F else 0.6F

    val textColor = if (isSelected) colors.primary else colors.onSurface.copy(alpha = 0.6F)

    val backgroundColor = if (isSelected) colors.primary.copy(alpha = 0.12F) else colors.surface

    Surface(
        modifier = modifier
            .fillMaxWidth()
            .padding(start = 8.dp, end = 8.dp, top = 8.dp)
    ) {
        Row(
            modifier = modifier
                .clickable(onClick = onClick)
                .fillMaxWidth()
                .padding(4.dp),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                imageVector = icon,
                contentDescription = "Screen Navigation Ui",
                colorFilter = ColorFilter.tint(textColor),
                alpha = imageAlpha
            )

            Spacer(modifier = modifier.width(16.dp))

            Text(
                modifier = modifier.fillMaxWidth(),
                text = label,
                style = MaterialTheme.typography.body2,
                color = textColor
            )

        }
    }
}

@Preview(showBackground = true)
@Composable
fun ScreenNavigationUiButtonPreview() {
    ScreenNavigationUiButton(
        icon = Icons.Filled.Menu,
        label = "Note",
        isSelected = false
    ) {

    }
}