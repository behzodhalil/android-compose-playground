package uz.behzoddev.a06_jetnotes_sample.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun AppDrawerUi(
    modifier: Modifier = Modifier,
    currentScreen: Screen,
    closeDrawerAction: () -> Unit
) {
    Column(
        modifier = modifier.fillMaxSize()
    ) {
        AppDrawerUiHeader()

        Divider(color = MaterialTheme.colors.onSurface.copy(0.2F))

        ScreenNavigationUiButton(
            icon = Icons.Filled.Menu,
            label = "Home",
            isSelected = currentScreen == Screen.Home,
            onClick = { closeDrawerAction() }
        )

        ScreenNavigationUiButton(
            icon = Icons.Filled.Delete,
            label = "Delete",
            isSelected = currentScreen == Screen.Delete,
            onClick = { closeDrawerAction() }
        )

        LightOrDarkUiTheme()
    }
}

@Preview(showBackground = true)
@Composable
fun AppDrawerUiPreview() {
    AppDrawerUi(currentScreen = Screen.Home, closeDrawerAction = {})
}