package uz.behzoddev.a02_thinking_in_compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import uz.behzoddev.a02_thinking_in_compose.`01-basic`.GreetingElevatedButtonExpanded
import uz.behzoddev.a02_thinking_in_compose.ui.theme.AndroidcomposeplaygroundTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AndroidcomposeplaygroundTheme {
               GreetingElevatedButtonExpanded()
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    AndroidcomposeplaygroundTheme {
        Greeting("Android")
    }
}