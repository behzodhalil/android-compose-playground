package uz.behzoddev.a06_jetnotes_sample.data.local.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import uz.behzoddev.a06_jetnotes_sample.data.local.entity.NoteEntityModel

/**
 * Dao for managing Note table in the database.
 */
@Dao
interface NoteDao {

    @Query("SELECT * FROM NoteEntityModel")
    fun getAllSync(): List<NoteEntityModel>

    @Query("SELECT * FROM NoteEntityModel WHERE id IN (:noteIds)")
    fun getNotesByIdsSync(noteIds: List<Long>): List<NoteEntityModel>

    @Query("SELECT * FROM NoteEntityModel WHERE id LIKE :id")
    fun findById(id: Long): LiveData<NoteEntityModel>

    @Query("SELECT * FROM NoteEntityModel WHERE id LIKE :id")
    fun findByIdSync(id: Long): NoteEntityModel

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(NoteEntityModel: NoteEntityModel)

    @Insert
    fun insertAll(vararg NoteEntityModel: NoteEntityModel)

    @Query("DELETE FROM NoteEntityModel WHERE id LIKE :id")
    fun delete(id: Long)

    @Query("DELETE FROM NoteEntityModel WHERE id IN (:noteIds)")
    fun delete(noteIds: List<Long>)
}