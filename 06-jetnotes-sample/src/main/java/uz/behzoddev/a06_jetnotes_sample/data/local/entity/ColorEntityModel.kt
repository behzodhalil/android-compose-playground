package uz.behzoddev.a06_jetnotes_sample.data.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class ColorEntityModel(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    @ColumnInfo(name = "hex") val hex: String,
    @ColumnInfo(name = "name") val name: String
) {

    companion object {

        val DEFAULT_COLORS = listOf(
            ColorEntityModel(1, "#FFFFFF", "White"),
            ColorEntityModel(2, "#E57373", "Red"),
            ColorEntityModel(3, "#F06292", "Pink"),
            ColorEntityModel(4, "#CE93D8", "Purple"),
            ColorEntityModel(5, "#2196F3", "Blue"),
            ColorEntityModel(6, "#00ACC1", "Cyan"),
            ColorEntityModel(7, "#26A69A", "Teal"),
            ColorEntityModel(8, "#4CAF50", "Green"),
            ColorEntityModel(9, "#8BC34A", "Light Green"),
            ColorEntityModel(10, "#CDDC39", "Lime"),
            ColorEntityModel(11, "#FFEB3B", "Yellow"),
            ColorEntityModel(12, "#FF9800", "Orange"),
            ColorEntityModel(13, "#BCAAA4", "Brown"),
            ColorEntityModel(14, "#9E9E9E", "Gray")
        )

        val DEFAULT_COLOR = DEFAULT_COLORS[0]
    }
}
