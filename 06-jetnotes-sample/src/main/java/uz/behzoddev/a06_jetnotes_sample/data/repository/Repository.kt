package uz.behzoddev.a06_jetnotes_sample.data.repository

import androidx.lifecycle.LiveData
import uz.behzoddev.a06_jetnotes_sample.data.local.entity.ColorEntityModel
import uz.behzoddev.a06_jetnotes_sample.data.local.entity.NoteEntityModel

/**
 * Allows communication with the app's database.
 */
interface Repository {

    fun getAllNotesNotInTrash(): LiveData<List<NoteEntityModel>>

    fun getAllNotesInTrash(): LiveData<List<NoteEntityModel>>

    fun getNote(id: Long): LiveData<NoteEntityModel>

    fun insertNote(note: NoteEntityModel)

    fun deleteNote(id: Long)

    fun deleteNotes(noteIds: List<Long>)

    fun moveNoteToTrash(noteId: Long)

    fun restoreNotesFromTrash(noteIds: List<Long>)

    fun getAllColors(): LiveData<List<ColorEntityModel>>

    fun getAllColorsSync(): List<ColorEntityModel>

    fun getColor(id: Long): LiveData<ColorEntityModel>

    fun getColorSync(id: Long): ColorEntityModel
}