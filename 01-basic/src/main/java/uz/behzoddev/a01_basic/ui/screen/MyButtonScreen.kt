package uz.behzoddev.a01_basic.ui.screen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Info
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import uz.behzoddev.a01_basic.R
import uz.behzoddev.a01_basic.ui.theme.AndroidComposePlaygroundTheme
import uz.behzoddev.a01_basic.ui.theme.PrimaryColor

@Composable
fun MyButtonScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        MyRadioGroup()
        MyTextButton()
    }
}


@Composable
fun MyButton() {
    Button(
        onClick = {},
        colors = ButtonDefaults.buttonColors(backgroundColor = PrimaryColor),
        border = BorderStroke(
            width = 1.dp,
            color = colorResource(id = R.color.black)
        )
    ) {
        Text(
            text = stringResource(id = R.string.click_me),
            color = colorResource(id = R.color.white),
            fontSize = 12.sp,
            fontWeight = FontWeight.Bold
        )
    }
}

@Composable
fun MyRadioGroup() {
    val radioButtons = listOf(1, 2, 3)

    val selectedButton = remember {
        mutableStateOf(radioButtons.first())
    }

    val colors = RadioButtonDefaults.colors(
        selectedColor = colorResource(id = R.color.teal_200),
        unselectedColor = colorResource(id = R.color.black),
        disabledColor = colorResource(id = R.color.white)
    )

    Column {
        radioButtons.forEach { index ->
            val isSelected = index == selectedButton.value

            RadioButton(
                colors = colors,
                selected = isSelected,
                onClick = {
                    selectedButton.value = index
                })
        }

    }
}

@Composable
fun MyFloatingActionButton() {
    FloatingActionButton(
        modifier = Modifier.padding(top = 4.dp),
        onClick = {},
        backgroundColor = PrimaryColor,
        contentColor = Color.Blue,
        content = {
            Icon(Icons.Filled.Face, contentDescription = "Test FAB")
        }
    )
}

@Composable
fun MyFloatingActionButtonWithElevation() {
    FloatingActionButton(
        modifier = Modifier.padding(top = 4.dp),
        onClick = {},
        backgroundColor = PrimaryColor,
        contentColor = Color.Red,
        elevation = FloatingActionButtonDefaults.elevation(defaultElevation = 12.dp)
    ) {
        Icon(Icons.Filled.Info, contentDescription = "Test FAB with elevation")
    }
}

@Composable
fun MyTextButton() {
    val colors = ButtonDefaults.textButtonColors(
        backgroundColor = Color.Magenta,
        contentColor = Color.Gray
    )

    TextButton(
        modifier = Modifier.padding(top = 10.dp),
        onClick = {},
        colors = colors,
        shape = MaterialTheme.shapes.medium,
        border = BorderStroke(1.dp, Color.White)
    ) {
        Text(
            text = stringResource(id = R.string.text_button),
            color = Color.White
        )
    }
}

@Preview
@Composable
fun MyButtonPreview() {
    AndroidComposePlaygroundTheme {
        MyButtonScreen()
    }
}