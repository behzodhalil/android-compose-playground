package uz.behzoddev.a01_basic.ui.screen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import uz.behzoddev.a01_basic.R
import uz.behzoddev.a01_basic.ui.theme.AndroidComposePlaygroundTheme
import kotlin.math.ceil

private val grids = listOf(
    Icons.Default.Face,
    Icons.Default.Favorite,
    Icons.Default.Menu,
    Icons.Default.Search,
    Icons.Default.AccountBox,
    Icons.Default.Settings,
    Icons.Default.Send
)

data class IconRecourse(
    val imageVector: ImageVector,
    val isVisible: Boolean
)

@Composable
fun MyGridScreen() {
    MyGrid(itemCount = 3)
}

@Composable
fun MyGrid(itemCount: Int) {
    val itemSize = grids.size
    val rowCount = ceil(itemSize.toFloat() / itemCount).toInt()
    val gridItems = mutableListOf<List<IconRecourse>>()
    var position = 0

    for (i in 0 until rowCount) {
        val rowItem = mutableListOf<IconRecourse>()
        for (j in 0 until itemCount) {
            if (position.inc() <= itemSize) {
                rowItem.add(IconRecourse(imageVector = grids[position++], true))
            }
        }

        val itemsToFill = itemSize - itemCount

        for (k in 0 until itemsToFill) {
            rowItem.add(IconRecourse(imageVector = Icons.Default.Delete, false))
        }
        gridItems.add(rowItem)
    }

    LazyColumn(modifier = Modifier.fillMaxSize()) {
        items(gridItems) { grid ->
            RowItem(rowItems = grid)
        }
    }


}

@Composable
fun RowItem(rowItems: List<IconRecourse>) {
    Row {
        for (element in rowItems) {
            GridIcon(icon = element)
        }
    }
}

@Composable
fun RowScope.GridIcon(icon: IconRecourse) {
    val color =
        if (icon.isVisible) colorResource(id = R.color.teal_700)
        else colorResource(id = R.color.teal_200)

    Icon(
        imageVector = icon.imageVector,
        tint = color,
        contentDescription = stringResource(id = R.string.app_name),
        modifier = Modifier
            .size(80.dp, 80.dp)
            .weight(1F)
    )

}

@Composable
@Preview
fun MyGridPreview() {
    AndroidComposePlaygroundTheme {
        MyGridScreen()
    }
}