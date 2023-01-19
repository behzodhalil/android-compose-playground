package uz.behzoddev.a07_reddit_sample.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.filled.Star
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import uz.behzoddev.a07_reddit_sample.R

@Composable
fun ProfileInfoUiComponent(
    modifier: Modifier = Modifier
) {
    ConstraintLayout(
        modifier = modifier
            .fillMaxWidth()
            .padding(top = 16.dp)
    ) {

        val (karmaItem, divider, ageItem) = createRefs()
        val colors = MaterialTheme.colors

        ProfileInfoItemUiComponent(
            iconAsset = Icons.Filled.Star,
            amountResourceId = R.string.amount,
            textResourceId = R.string.text,
            modifier = modifier
                .constrainAs(karmaItem) {
                    centerVerticallyTo(parent)
                    start.linkTo(parent.start)
                }
                .padding(start = 8.dp, bottom = 12.dp)
        )

        Divider(
            modifier = modifier
                .width(1.dp)
                .constrainAs(divider) {
                    centerVerticallyTo(karmaItem)
                    centerHorizontallyTo(parent)
                    height = Dimension.fillToConstraints
                },
            color = colors.onSurface.copy(alpha = 0.2F)
        )

        ProfileInfoItemUiComponent(
            iconAsset = Icons.Filled.ShoppingCart,
            amountResourceId = R.string.amount,
            textResourceId = R.string.text,
            modifier = modifier
                .constrainAs(ageItem) {
                    start.linkTo(divider.end)
                    centerVerticallyTo(parent)
                }
                .padding(start = 8.dp, bottom = 12.dp)
        )
    }
}

@Composable
@Preview(showBackground = true)
fun ProfileInfoUiComponentPreview() {
    ProfileInfoUiComponent()
}