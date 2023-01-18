package uz.behzoddev.a06_jetnotes_sample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import uz.behzoddev.a06_jetnotes_sample.core_ui.theme.AndroidComposePlaygroundTheme
import uz.behzoddev.a06_jetnotes_sample.presentation.screen.NoteScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NoteScreen()
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
    AndroidComposePlaygroundTheme {
        Greeting("Android")
    }
}