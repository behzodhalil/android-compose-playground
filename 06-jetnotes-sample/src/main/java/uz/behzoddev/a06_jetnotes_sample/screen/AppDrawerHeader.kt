package uz.behzoddev.a06_jetnotes_sample.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun AppDrawerUiHeader(
    modifier: Modifier = Modifier
) {
    Row(modifier = modifier.fillMaxWidth()) {
        Image(
            modifier = modifier.padding(16.dp),
            imageVector = Icons.Filled.Menu,
            colorFilter = ColorFilter.tint(MaterialTheme.colors.onSurface),
            contentDescription = "Jet Notes Image"
        )

        Text(
            modifier = Modifier.align(Alignment.CenterVertically),
            text = "Jet Notes",
            fontWeight = FontWeight.Medium
        )
    }
}

@Composable
@Preview(showBackground = true)
fun AppDrawerUiHeaderPreview() {
    AppDrawerUiHeader()
}