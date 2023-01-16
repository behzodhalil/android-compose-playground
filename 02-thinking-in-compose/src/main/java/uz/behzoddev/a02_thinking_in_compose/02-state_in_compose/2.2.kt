package uz.behzoddev.a02_thinking_in_compose.`02-state_in_compose`

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Checkbox
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun WellnessItemTask(
    modifier: Modifier = Modifier,
    taskName: String,
    checked: Boolean,
    onChecked: (Boolean) -> Unit,
    onClick: () -> Unit
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = taskName,
            color = Color.Black,
            modifier = modifier
                .weight(1F)
                .padding(start = 16.dp)
        )

        Checkbox(
            checked = checked,
            onCheckedChange = { onChecked(it) })

        IconButton(onClick = { onClick() }) {
            Icon(imageVector = Icons.Filled.Close, contentDescription = "")
        }
    }
}

@Composable
fun WellCheckNessItem(
    modifier: Modifier = Modifier,
    taskName: String = "Task name"
) {
    val checkedState = remember {
        mutableStateOf(false)
    }

    WellnessItemTask(
        taskName = taskName,
        checked = checkedState.value,
        onChecked = { newValue -> checkedState.value = newValue },
        modifier = modifier
    ) {

    }
}

@Preview
@Composable
fun WellnessItemTaskPreview() {
    WellnessItemTask(taskName = "TaskName", checked = true, onChecked = {}, onClick = {})
}