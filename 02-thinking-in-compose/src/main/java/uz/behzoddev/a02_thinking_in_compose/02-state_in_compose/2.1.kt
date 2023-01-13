package uz.behzoddev.a02_thinking_in_compose.`02-state_in_compose`

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun WaterScreen(modifier: Modifier = Modifier) {
    WaterCounter(modifier)
}

@Composable
fun WaterCounter(modifier: Modifier = Modifier) {
    var count = 0
    Surface(modifier = modifier.padding(8.dp)) {
        Row() {
            Text(
                text = "You've received $count",
                modifier = modifier.padding(8.dp)
            )
            Button(
                onClick = { count++ },
                modifier = modifier.padding(start = 12.dp)
            ) {
                Text(text = "Add")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun WaterCounterPreview() {
    WaterCounter()
}
