package uz.behzoddev.a06_jetnotes_sample.presentation.component

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import uz.behzoddev.a06_jetnotes_sample.data.local.entity.ColorEntityModel
import uz.behzoddev.a06_jetnotes_sample.screen.NoteColorUi

@Composable
fun PickedColorUiComponent(
    modifier: Modifier = Modifier,
    color: ColorEntityModel
) {
    Row(
        modifier = modifier
            .padding(8.dp)
            .padding(top = 16.dp)
    ) {
        Text(
            modifier = modifier
                .weight(1F)
                .align(Alignment.CenterVertically),
            text = "Picked Color"
        )
        NoteColorUi(
            modifier = modifier.padding(4.dp),
            size = 40.dp,
            color = Color.Magenta,
            border = 1.dp
        )
    }
}

@Composable
@Preview(showBackground = true)
fun PickedColorUiComponentPreview() {
    PickedColorUiComponent(color = ColorEntityModel.DEFAULT_COLOR)
}
