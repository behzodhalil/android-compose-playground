package uz.behzoddev.a06_jetnotes_sample.data.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
data class NoteEntityModel(
    @PrimaryKey(autoGenerate = true) var id: Long = 0L,
    @ColumnInfo(name = "title") var title: String = "",
    @ColumnInfo(name = "content") var content: String = "",
    @ColumnInfo(name = "can_be_checked_off") var canBeCheckedOff: Boolean = false,
    @ColumnInfo(name = "is_checked_off") var isCheckedOff: Boolean = false,
    @ColumnInfo(name = "color_id") var colorId: Long = 0L,
    @ColumnInfo(name = "in_trash") var isInTrash: Boolean = false
) {

    companion object {

        val DEFAULT_NOTES = listOf(
            NoteEntityModel(1, "RW Meeting", "Prepare sample project", false, false, 1, false),
            NoteEntityModel(2, "Bills", "Pay by tomorrow", false, false, 2, false),
            NoteEntityModel(3, "Pancake recipe", "Milk, eggs, salt, flour...", false, false, 3, false),
            NoteEntityModel(4, "Workout", "Running, push ups, pull ups, squats...", false, false, 4, false),
            NoteEntityModel(5, "Title 5", "Content 5", false, false, 5, false),
            NoteEntityModel(6, "Title 6", "Content 6", false, false, 6, false),
            NoteEntityModel(7, "Title 7", "Content 7", false, false, 7, false),
            NoteEntityModel(8, "Title 8", "Content 8", false, false, 8, false),
            NoteEntityModel(9, "Title 9", "Content 9", false, false, 9, false),
            NoteEntityModel(10, "Title 10", "Content 10", false, false, 10, false),
            NoteEntityModel(11, "Title 11", "Content 11", true, false, 11, false),
            NoteEntityModel(12, "Title 12", "Content 12", true, false, 12, false)
        )

        val DEFAULT_NOTE = NoteEntityModel(1, "RW Meeting", "Prepare sample project", false, false, 1, false)
    }
}
