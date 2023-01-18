package uz.behzoddev.a06_jetnotes_sample.data.local.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import uz.behzoddev.a06_jetnotes_sample.data.local.entity.ColorEntityModel

/**
 * Dao for managing Color table in the database.
 */
@Dao
interface ColorDao {

    @Query("SELECT * FROM ColorEntityModel")
    fun getAll(): LiveData<List<ColorEntityModel>>

    @Query("SELECT * FROM ColorEntityModel")
    fun getAllSync(): List<ColorEntityModel>


    @Query("SELECT * FROM ColorEntityModel WHERE id LIKE :id")
    fun findById(id: Long): LiveData<ColorEntityModel>

    @Query("SELECT * FROM ColorEntityModel WHERE id LIKE :id")
    fun findByIdSync(id: Long): ColorEntityModel

    @Insert
    fun insertAll(vararg ColorEntityModels: ColorEntityModel)
}