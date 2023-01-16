package uz.behzoddev.a02_thinking_in_compose.`01-basic`

import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import uz.behzoddev.a02_thinking_in_compose.ui.theme.Teal200

@Composable
fun MyGreeting(text: String) {
    Text(
        text = text,
        color = Teal200,
        fontWeight = FontWeight.Bold
    )
}

@Composable
fun MyGreetingWithSurface(text: String) {
    Surface(color = MaterialTheme.colors.primary) {
        Text(
            text = text,
            fontSize = 14.sp,
            color = Color.Black,
            modifier = Modifier.padding(24.dp)
        )
    }
}

@Composable
fun MyGreetingWithModifier(modifier: Modifier = Modifier) {
    Surface(
        modifier = modifier,
        color = MaterialTheme.colors.primary
    ) {
        Text(
            text = "Hello, Modifier!",
            color = Color.White,
            modifier = modifier.padding(24.dp)
        )
    }
}

@Composable
@Preview(name = "My Greeting Preview", showBackground = true)
fun MyGreetingPreview() {
    MyGreetingWithModifier()
}