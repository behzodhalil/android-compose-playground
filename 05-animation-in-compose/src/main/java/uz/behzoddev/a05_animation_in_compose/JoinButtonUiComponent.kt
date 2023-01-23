package uz.behzoddev.a05_animation_in_compose

import androidx.compose.animation.animateColor
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateDp
import androidx.compose.animation.core.tween
import androidx.compose.animation.core.updateTransition
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
Upimport androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Check
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun JoinButtonUiComponent(
    modifier: Modifier = Modifier,
    onClickAction: (Boolean) -> Unit
) {

    val buttonState = remember {
        mutableStateOf(JoinButtonState.IDLE)
    }

    val duration = 600

    val shape = RoundedCornerShape(corner = CornerSize(12.dp))

    val transition = updateTransition(
        targetState = buttonState,
        label = "Join Button Transition"
    )
    val backgroundColor: Color by animateColorAsState(
        targetValue =
        if (buttonState.value == JoinButtonState.PRESSED)
            Color.White
        else
            Color.Blue
    )

    val buttonBackgroundColor: Color by transition.animateColor(
        transitionSpec = { tween(duration) },
        label = "Join button transition "
    ) { state ->
        when (state.value) {
            JoinButtonState.IDLE -> Color.Blue
            JoinButtonState.PRESSED -> Color.White
        }
    }

    val textWidth: Dp by transition.animateDp(
        transitionSpec = { tween(duration) },
        label = "Text width transaction"
    ) { state ->
        when (state.value) {
            JoinButtonState.IDLE -> 70.dp
            JoinButtonState.PRESSED -> 0.dp
        }
    }

    val buttonWidth: Dp by transition.animateDp(
        transitionSpec = { tween(duration) },
        label = "Button width transaction"
    ) { state ->
        when (state.value) {
            JoinButtonState.IDLE -> 70.dp
            JoinButtonState.PRESSED -> 32.dp
        }
    }

    val iconAsset: ImageVector =
        if (buttonState.value == JoinButtonState.PRESSED) {
            Icons.Default.Check
        } else {
            Icons.Default.Add
        }

    val iconTintColor: Color =
        if (buttonState.value == JoinButtonState.PRESSED)
            Color.Blue
        else
            Color.White

    Box(
        modifier = modifier
            .clip(shape)
            .border(width = 1.dp, color = Color.White, shape = shape)
            .background(color = buttonBackgroundColor)
            .size(width = buttonWidth, height = 24.dp)
            .clickable(onClick = {
                buttonState.value =
                    if (buttonState.value == JoinButtonState.IDLE) {
                        onClickAction.invoke(true)
                        JoinButtonState.PRESSED
                    } else {
                        onClickAction.invoke(false)
                        JoinButtonState.IDLE
                    }
            }),
        contentAlignment = Alignment.Center
    ) {
        Row(modifier  = modifier.fillMaxWidth()) {
            Icon(
                modifier = modifier
                    .size(16.dp)
                ,
                imageVector = iconAsset,
                contentDescription = "",
                tint = iconTintColor
            )

            Spacer(modifier = modifier.width(8.dp))

            Text(
                text = "Join",
                style = TextStyle(
                    color = Color.White,
                    fontSize = 14.sp
                ),
                maxLines = 1,
                modifier = modifier.widthIn(
                    min = 0.dp,
                    max = textWidth
                )
            )
        }

    }
}

enum class JoinButtonState {
    IDLE,
    PRESSED
}

@Composable
@Preview
fun JoinButtonUiPreviewComponent() {
    JoinButtonUiComponent(onClickAction = {})
}