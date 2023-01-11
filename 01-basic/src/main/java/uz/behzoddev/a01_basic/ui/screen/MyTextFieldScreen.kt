package uz.behzoddev.a01_basic.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import uz.behzoddev.a01_basic.R
import uz.behzoddev.a01_basic.ui.theme.AndroidComposePlaygroundTheme
import uz.behzoddev.a01_basic.ui.theme.PrimaryColor

@Composable
fun MyTextFieldScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        MyTextField()
        MyOutlineTextField()
        MyTextFieldWithNumber()
    }
}

@Composable
private fun MyTextField() {
    val textValue = remember { mutableStateOf("") }

    TextField(
        value = textValue.value,
        onValueChange = {
            textValue.value = it
        },
        label = {}
    )
}

@Composable
private fun MyOutlineTextField() {
    val textValue = remember {
        mutableStateOf("")
    }

    // label takes parameter composable function.
    OutlinedTextField(
        label = { Text(text = stringResource(id = R.string.email)) },
        value = textValue.value,
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = PrimaryColor,
            focusedLabelColor = PrimaryColor,
            cursorColor = PrimaryColor
        ),
        keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Email),
        onValueChange = { targetValue ->
            textValue.value = targetValue
        }
    )
}

@Composable
private fun MyTextFieldWithNumber() {

    val number = remember {
        mutableStateOf("")
    }

    OutlinedTextField(
        label = { Text(text = stringResource(id = R.string.number)) },
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedLabelColor = PrimaryColor,
            focusedBorderColor = PrimaryColor,
            cursorColor = PrimaryColor
        ),
        keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number),
        value = number.value,
        onValueChange = {
            number.value = it
        }
    )
}

@Composable
@Preview
private fun MyTextFieldPreview() {
    AndroidComposePlaygroundTheme {
        MyTextFieldScreen()
    }
}


