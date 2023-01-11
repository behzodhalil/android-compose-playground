package uz.behzoddev.a01_basic.ui.screen

import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import uz.behzoddev.a01_basic.R


@Composable
fun MyComposableScreen() {
    MyComposableFunction()
}

@Composable
fun MyComposableFunction() {
    Text(
        text = stringResource(id = R.string.my_composable_function)
    )
}

