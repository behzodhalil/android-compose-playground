package uz.behzoddev.a07_reddit_sample.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import uz.behzoddev.a07_reddit_sample.R

@Composable
fun DrawerHeaderUiComponent(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            modifier = modifier
                .padding(16.dp)
                .size(50.dp),
            imageVector = Icons.Filled.AccountCircle,
            colorFilter = ColorFilter.tint(Color.LightGray),
            contentDescription = "Header Image",
            alignment = Alignment.Center,
            contentScale = ContentScale.Fit
        )

        Text(
            text = stringResource(id = R.string.user_name),
            style = TextStyle(
                color = MaterialTheme.colors.primary,
                fontWeight = FontWeight.Normal,
                fontSize = 21.sp
            )
        )

        Divider(
            modifier = modifier.padding(
                start = 16.dp,
                end = 16.dp,
                top = 16.dp
            ),
            color = MaterialTheme.colors.onSurface.copy(alpha = 0.2F)
        )

        ProfileInfoUiComponent()
    }
}

@Composable
@Preview(showBackground = true)
private fun DrawerHeaderUiComponentPreview() {
    DrawerHeaderUiComponent()
}