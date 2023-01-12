package uz.behzoddev.a01_basic

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import uz.behzoddev.a01_basic.ui.screen.MyDialogScreen
import uz.behzoddev.a01_basic.ui.screen.MyListScreen
import uz.behzoddev.a01_basic.ui.screen.MyScrollingScreen
import uz.behzoddev.a01_basic.ui.screen.MyTextFieldScreen
import uz.behzoddev.a01_basic.ui.theme.AndroidComposePlaygroundTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AndroidComposePlaygroundTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    MyListScreen()
                }
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
    AndroidComposePlaygroundTheme {
        Greeting("Android")
    }
}