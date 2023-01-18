package uz.behzoddev.a06_jetnotes_sample.data.local.core

import androidx.room.Database
import androidx.room.RoomDatabase
import uz.behzoddev.a06_jetnotes_sample.data.local.dao.ColorDao
import uz.behzoddev.a06_jetnotes_sample.data.local.dao.NoteDao
import uz.behzoddev.a06_jetnotes_sample.data.local.entity.ColorEntityModel
import uz.behzoddev.a06_jetnotes_sample.data.local.entity.NoteEntityModel

/**
 * App's database.
 *
 * It contains two tables: Note table and Color table.
 */
@Database(entities = [NoteEntityModel::class, ColorEntityModel::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    companion object {
        const val DATABASE_NAME = "note-maker-database"
    }

    abstract fun noteDao(): NoteDao

    abstract fun colorDao(): ColorDao
}