package uz.behzoddev.a07_reddit_sample.ui.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import uz.behzoddev.a07_reddit_sample.R

@Composable
fun ProfileInfoItemUiComponent(
    modifier: Modifier = Modifier,
    iconAsset: ImageVector,
    amountResourceId: Int,
    textResourceId: Int
) {
    val colors = MaterialTheme.colors

    ConstraintLayout(modifier = modifier) {
        val (iconRef, titleRef, amountRef) = createRefs()
        val itemModifier = Modifier

        Icon(
            imageVector = iconAsset,
            contentDescription = "",
            tint = Color.Blue,
            modifier = itemModifier
                .constrainAs(iconRef) {
                    centerVerticallyTo(parent)
                    start.linkTo(parent.start)
                }
        )

        Text(
            text = stringResource(id = amountResourceId),
            color = colors.primaryVariant,
            fontSize = 12.sp,
            modifier = itemModifier
                .padding(start = 8.dp, end = 8.dp)
                .constrainAs(amountRef) {
                    top.linkTo(iconRef.top)
                    start.linkTo(iconRef.end)
                    bottom.linkTo(titleRef.top)
                }
        )

        Text(
            text = stringResource(textResourceId),
            color = Color.Gray,
            fontSize = 10.sp,
            modifier = itemModifier
                .padding(start = 8.dp)
                .constrainAs(titleRef) {
                    top.linkTo(amountRef.bottom)
                    start.linkTo(iconRef.end)
                    bottom.linkTo(iconRef.bottom)
                }
        )
    }
}

@Composable
@Preview(showBackground = true)
fun ProfileInfoItemUiComponentPreview() {
    ProfileInfoItemUiComponent(
        iconAsset = Icons.Filled.AccountCircle,
        amountResourceId = R.string.amount,
        textResourceId = R.string.text
    )
}