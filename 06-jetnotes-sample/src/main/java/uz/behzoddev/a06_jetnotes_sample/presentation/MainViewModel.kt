package uz.behzoddev.a06_jetnotes_sample.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import uz.behzoddev.a06_jetnotes_sample.data.local.entity.ColorEntityModel
import uz.behzoddev.a06_jetnotes_sample.data.local.entity.NoteEntityModel
import uz.behzoddev.a06_jetnotes_sample.data.repository.Repository


class MainViewModel(
    private val repository: Repository
) : ViewModel() {

    val notesNotInTrash: LiveData<List<NoteEntityModel>> by lazy {
        repository.getAllNotesInTrash()
    }

    private var _noteEntry = MutableLiveData(NoteEntityModel())
    val noteEntry: LiveData<NoteEntityModel> = _noteEntry

    val colors: LiveData<List<ColorEntityModel>> by lazy {
        repository.getAllColors()
    }

    val notesInTrash by lazy { repository.getAllNotesInTrash() }

    private var _selectedNotes = MutableLiveData<List<NoteEntityModel>>(emptyList())
    val selectedNotes: LiveData<List<NoteEntityModel>> = _selectedNotes

    fun onCreateNewNoteClick() {
        _noteEntry.value = NoteEntityModel()
    }

    fun onNoteCheckedChange(note: NoteEntityModel) {
        viewModelScope.launch(Dispatchers.Default) {
            repository.insertNote(note)
        }
    }

    fun onNoteSelected(note: NoteEntityModel) {
        _selectedNotes.value = _selectedNotes.value!!.toMutableList().apply {
            if (contains(note)) {
                remove(note)
            } else {
                add(note)
            }
        }
    }

    fun restoreNotes(notes: List<NoteEntityModel>) {
        viewModelScope.launch(Dispatchers.Default) {
            repository.restoreNotesFromTrash(notes.map { it.id })
            withContext(Dispatchers.Main) {
                _selectedNotes.value = listOf()
            }
        }
    }

    fun permanentlyDeleteNotes(notes: List<NoteEntityModel>) {
        viewModelScope.launch(Dispatchers.Default) {
            repository.deleteNotes(notes.map { it.id })
            withContext(Dispatchers.Main) {
                _selectedNotes.value = listOf()
            }
        }
    }

    fun onNoteEntryChange(note: NoteEntityModel) {
        _noteEntry.value = note
    }

    fun saveNote(note: NoteEntityModel) {
        viewModelScope.launch(Dispatchers.Default) {
            repository.insertNote(note)

            withContext(Dispatchers.Main) {
                

                _noteEntry.value = NoteEntityModel()
            }
        }
    }

    fun moveNoteToTrash(note: NoteEntityModel) {
        viewModelScope.launch(Dispatchers.Default) {
            repository.moveNoteToTrash(note.id)

            withContext(Dispatchers.Main) {

            }
        }
    }
}