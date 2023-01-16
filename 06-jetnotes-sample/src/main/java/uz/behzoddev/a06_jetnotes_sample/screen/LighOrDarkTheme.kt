package uz.behzoddev.a06_jetnotes_sample.screen

import android.graphics.fonts.FontStyle
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Switch
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun LightOrDarkUiTheme(
    modifier: Modifier = Modifier
) {
    Row(modifier = modifier.padding(8.dp)) {
        Text(
            modifier = modifier
                .weight(1F)
                .padding(8.dp)
                .align(Alignment.CenterVertically),
            text = "Turn on dark theme",
            style = MaterialTheme.typography.body2,
            color = MaterialTheme.colors.onSurface.copy(alpha = 0.6F)
        )

        Switch(
            modifier = modifier
                .padding(8.dp)
                .align(Alignment.CenterVertically),
            checked = false, onCheckedChange = {})
    }
}

@Preview(showBackground = true)
@Composable
fun LightOrDarkUiThemePreview() {
    LightOrDarkUiTheme()
}