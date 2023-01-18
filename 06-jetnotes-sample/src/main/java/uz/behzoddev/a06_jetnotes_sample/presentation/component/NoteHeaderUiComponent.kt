package uz.behzoddev.a06_jetnotes_sample.presentation.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun NoteHeaderUiComponent(
    modifier: Modifier = Modifier,
    onIconClick: () -> Unit
) {
    Row(
        modifier = modifier.fillMaxWidth()
    ) {
        Image(
            modifier = modifier
                .padding(16.dp)
                .clickable { onIconClick() },
            imageVector = Icons.Filled.Menu,
            colorFilter = ColorFilter.tint(MaterialTheme.colors.onSurface),
            contentDescription = "",
        )

        Text(
            modifier = modifier.padding(16.dp),
            text = "Jet Notes",
            style = TextStyle(
                color = Color.Black,
                fontSize = 18.sp,
                fontWeight = FontWeight.Medium
            )
        )
    }
}

@Composable
@Preview(showBackground = true)
fun NoteHeaderUiComponentPreview() {
    NoteHeaderUiComponent(onIconClick = {})
}