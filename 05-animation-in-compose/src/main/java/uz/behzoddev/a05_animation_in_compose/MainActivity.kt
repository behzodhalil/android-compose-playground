package uz.behzoddev.a05_animation_in_compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import uz.behzoddev.a05_animation_in_compose.ui.theme.AndroidcomposeplaygroundTheme
import java.util.*
import kotlin.concurrent.schedule

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AndroidcomposeplaygroundTheme {
                val isToastVisible = remember { mutableStateOf(false) }

                val onJoinClickAction: (Boolean) -> Unit = { joined ->
                    isToastVisible.value = joined
                    if (isToastVisible.value) {
                        Timer().schedule(3000) {
                            isToastVisible.value = false
                        }
                    }
                }

                Column(modifier = Modifier.fillMaxSize()) {
                    JoinButtonUiComponent(onClickAction = onJoinClickAction)

                    Box(
                        modifier = Modifier.padding(8.dp),
                        contentAlignment = Alignment.BottomCenter
                    ) {
                        JoinedToastUiComponent(visible = isToastVisible.value)
                    }
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
    AndroidcomposeplaygroundTheme {
        Greeting("Android")
    }
}