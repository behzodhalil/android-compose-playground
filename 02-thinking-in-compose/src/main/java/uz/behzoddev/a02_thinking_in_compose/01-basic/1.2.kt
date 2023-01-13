package uz.behzoddev.a02_thinking_in_compose.`01-basic`

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import uz.behzoddev.a02_thinking_in_compose.ui.theme.Teal200

@Composable
fun GreetingElevatedButton(
    number: String
) {
    Surface(
        color = MaterialTheme.colors.primary,
        modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp),
        shape = RoundedCornerShape(12.dp)
    ) {
        Row(modifier = Modifier.padding(24.dp)) {
            Column(modifier = Modifier.weight(1F)) {
                Text(text = "Hello")
                Text(text = "Behzod")
                Text(text = number)
            }

            val colors = ButtonDefaults.buttonColors(
                backgroundColor = Teal200
            )
            Button(
                onClick = { /*TODO*/ },
                colors = colors,
                shape = RoundedCornerShape(8.dp)
            ) {
                Text(text = "Show more")
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
fun GreetingElevatedButtonPreview() {

}