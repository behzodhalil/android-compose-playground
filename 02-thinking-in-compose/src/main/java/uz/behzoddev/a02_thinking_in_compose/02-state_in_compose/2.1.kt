package uz.behzoddev.a02_thinking_in_compose.`02-state_in_compose`

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun WaterScreen(modifier: Modifier = Modifier) {
    WaterCounter(modifier)
}

@Composable
fun WaterCounter(modifier: Modifier = Modifier) {

    Surface(modifier = modifier.padding(8.dp)) {
        Row() {
            val count: MutableState<Int> = remember {
                mutableStateOf(0)
            }
            if (count.value > 0) {
                val showTask = remember {
                    mutableStateOf(true)
                }

                if (showTask.value) {
                    WaterTask(
                        taskName = "Have you taken your 15 minute walk today?",
                        onClick = { showTask.value = false })
                }
                Text(
                    text = "You've received ${count.value}",
                    modifier = modifier.padding(8.dp)
                )
            }

            Button(
                onClick = { count.value++ },
                enabled = count.value<10,
                modifier = modifier.padding(start = 12.dp)
            ) {
                Text(text = "Add")
            }
        }
    }
}

@Composable
fun WaterTask(
    taskName: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            modifier = modifier
                .weight(1F)
                .padding(16.dp),
            text = taskName
        )

        IconButton(onClick = { onClick() }) {
            Icon(imageVector = Icons.Filled.Close, contentDescription = "")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun WaterCounterPreview() {
    WaterCounter()
}
