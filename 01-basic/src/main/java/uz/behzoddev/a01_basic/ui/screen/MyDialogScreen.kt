package uz.behzoddev.a01_basic.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.AlertDialog
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import uz.behzoddev.a01_basic.R
import uz.behzoddev.a01_basic.ui.theme.AndroidComposePlaygroundTheme

@Composable
fun MyDialogScreen() {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        MyDialog()
    }
}

@Composable
fun MyDialog() {
    val isShown = remember {
        mutableStateOf(true)
    }

    if (isShown.value) {
        AlertDialog(
            onDismissRequest = {
                isShown.value = false
            },
            dismissButton = {
                CancelButton {
                    isShown.value = false
                }
            },
            title = { Title() },
            text = { DialogText() },
            confirmButton = {
                ConfirmButton {
                    isShown.value = false
                }
            }
        )
    }

}

@Composable
private fun Title() {
    Text(text = stringResource(id = R.string.alert_dialog_title))
}

@Composable
private fun DialogText() {
    Text(text = stringResource(id = R.string.alert_dialog_text))
}

@Composable
private fun CancelButton(block: () -> Unit) {
    Button(
        colors = ButtonDefaults.buttonColors(
            backgroundColor = Color.White,
            contentColor = Color.Black
        ),
        onClick = { block() }) {
        Text(text = stringResource(id = R.string.alert_dialog_cancel))
    }
}

@Composable
private fun ConfirmButton(onClick: () -> Unit) {
    Button(
        colors = ButtonDefaults.buttonColors(
            backgroundColor = Color.Magenta
        ),
        onClick = { onClick() }) {
        Text(
            text = stringResource(id = R.string.alert_dialog_confirm),
            color = Color.White
        )
    }
}

@Composable
@Preview
fun MyDialogPreview() {
    AndroidComposePlaygroundTheme {
        MyDialogScreen()
    }
}