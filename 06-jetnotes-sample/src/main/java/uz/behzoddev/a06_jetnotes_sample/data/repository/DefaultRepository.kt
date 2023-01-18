package uz.behzoddev.a06_jetnotes_sample.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import uz.behzoddev.a06_jetnotes_sample.data.local.dao.ColorDao
import uz.behzoddev.a06_jetnotes_sample.data.local.dao.NoteDao
import uz.behzoddev.a06_jetnotes_sample.data.local.entity.ColorEntityModel
import uz.behzoddev.a06_jetnotes_sample.data.local.entity.NoteEntityModel

class DefaultRepository(
    private val noteDao: NoteDao,
    private val colorDao: ColorDao,
) : Repository {

    private val notesNotInTrashLiveData: MutableLiveData<List<NoteEntityModel>> by lazy {
        MutableLiveData<List<NoteEntityModel>>()
    }

    private val notesInTrashLiveData: MutableLiveData<List<NoteEntityModel>> by lazy {
        MutableLiveData<List<NoteEntityModel>>()
    }

    init {
        initDatabase(this::updateNotesLiveData)
    }

    /**
     * Populates database with colors if it is empty.
     */
    @OptIn(DelicateCoroutinesApi::class)
    private fun initDatabase(postInitAction: () -> Unit) {
        GlobalScope.launch {
            val colors = ColorEntityModel.DEFAULT_COLORS.toTypedArray()
            val dbColors = colorDao.getAllSync()
            if (dbColors.isNullOrEmpty()) {
                colorDao.insertAll(*colors)
            }

            val notes = NoteEntityModel.DEFAULT_NOTES.toTypedArray()
            val dbNotes = noteDao.getAllSync()
            if (dbNotes.isNullOrEmpty()) {
                noteDao.insertAll(*notes)
            }

            postInitAction.invoke()
        }
    }

    override fun getAllNotesNotInTrash(): LiveData<List<NoteEntityModel>> = notesNotInTrashLiveData

    override fun getAllNotesInTrash(): LiveData<List<NoteEntityModel>> = notesInTrashLiveData

    private fun getAllNotesDependingOnTrashStateSync(inTrash: Boolean): List<NoteEntityModel> {
        val colorDbModels: Map<Long, ColorEntityModel> = colorDao.getAllSync().associateBy { it.id }
        return noteDao.getAllSync().filter { it.isInTrash == inTrash }
    }

    override fun getNote(id: Long): LiveData<NoteEntityModel> = noteDao.findById(id)

    override fun insertNote(note: NoteEntityModel) {
        noteDao.insert(note)
        updateNotesLiveData()
    }

    override fun deleteNote(id: Long) {
        noteDao.delete(id)
        updateNotesLiveData()
    }

    override fun deleteNotes(noteIds: List<Long>) {
        noteDao.delete(noteIds)
        updateNotesLiveData()
    }

    override fun moveNoteToTrash(noteId: Long) {
        val dbNote = noteDao.findByIdSync(noteId)
        val newDbNote = dbNote.copy(isInTrash = true)
        noteDao.insert(newDbNote)
        updateNotesLiveData()
    }

    override fun restoreNotesFromTrash(noteIds: List<Long>) {
        val dbNotesInTrash = noteDao.getNotesByIdsSync(noteIds)
        dbNotesInTrash.forEach {
            val newDbNote = it.copy(isInTrash = false)
            noteDao.insert(newDbNote)
        }
        updateNotesLiveData()
    }

    override fun getAllColors(): LiveData<List<ColorEntityModel>> = colorDao.getAll()

    override fun getAllColorsSync(): List<ColorEntityModel> =colorDao.getAllSync()

    override fun getColor(id: Long): LiveData<ColorEntityModel> =
        colorDao.findById(id)

    override fun getColorSync(id: Long): ColorEntityModel = (colorDao.findByIdSync(id))

    private fun updateNotesLiveData() {
        notesNotInTrashLiveData.postValue(getAllNotesDependingOnTrashStateSync(false))
        val newNotesInTrashLiveData = getAllNotesDependingOnTrashStateSync(true)
        notesInTrashLiveData.postValue(newNotesInTrashLiveData)
    }
}