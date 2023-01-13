package uz.behzoddev.a02_thinking_in_compose.`01-basic`

import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import uz.behzoddev.a02_thinking_in_compose.ui.theme.Teal200

@Composable
fun GreetingElevatedButtonExpanded() {
    val expanded = remember {
        mutableStateOf(false)
    }

    val extraPadding = animateDpAsState(
        targetValue = if (expanded.value) 48.dp else 0.dp,
        animationSpec = spring(
            dampingRatio = Spring.DampingRatioMediumBouncy,
            stiffness = Spring.StiffnessLow
        )
    )

    Surface(
        color = MaterialTheme.colors.primary,
        modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp),
        shape = RoundedCornerShape(12.dp)
    ) {
        Row(modifier = Modifier.padding(24.dp)) {
            Column(
                modifier = Modifier
                    .weight(1F)
                    .padding(bottom = extraPadding.value.coerceAtLeast(0.dp))
            ) {
                Text(text = "Hello")
                Text(text = "Behzod")
            }

            val colors = ButtonDefaults.buttonColors(
                backgroundColor = Teal200
            )
            Button(
                onClick = { expanded.value = !expanded.value },
                colors = colors,
                shape = RoundedCornerShape(8.dp)
            ) {
                Text(text = if (expanded.value) "Show less" else "Show More")
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
fun GreetingElevatedButtonExpandedPreview() {
    GreetingElevatedButtonExpanded()
}