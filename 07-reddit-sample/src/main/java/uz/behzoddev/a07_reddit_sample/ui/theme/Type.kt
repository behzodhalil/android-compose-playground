package uz.behzoddev.a07_reddit_sample.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

// Set of Material typography styles to start with
val Typography = Typography(
    body1 = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    )
    /* Other default text styles to override
    button = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.W500,
        fontSize = 14.sp
    ),
    caption = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp
    )
    */
)

/*
@Composable
fun ProfileInfo(modifier: Modifier = Modifier) {
    ConstraintLayout(
        modifier = modifier
            .fillMaxWidth()
            .padding(top = 16.dp)
    ) {
        val (karmaItem, divider, ageItem) = createRefs()
        val colors = MaterialTheme.colors

        ProfileInfoItem(
            Icons.Filled.Star,
            R.string.default_karma_amount,
            R.string.karma,
            modifier = modifier.constrainAs(karmaItem) {
                centerVerticallyTo(parent)
                start.linkTo(parent.start)
            }
        )

        Divider(
            modifier = modifier
                .width(1.dp)
                .constrainAs(divider) {
                    centerVerticallyTo(karmaItem)
                    centerHorizontallyTo(parent)
                    height = Dimension.fillToConstraints
                },
            color = colors.onSurface.copy(alpha = .2f)
        )

        ProfileInfoItem(
            Icons.Filled.ShoppingCart,
            R.string.default_reddit_age_amount,
            R.string.reddit_age,
            modifier = modifier.constrainAs(ageItem) {
                start.linkTo(divider.end)
                centerVerticallyTo(parent)
            }
        )
    }
}
*/
