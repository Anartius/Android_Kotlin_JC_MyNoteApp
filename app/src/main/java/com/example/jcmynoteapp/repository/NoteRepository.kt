package com.example.jcmynoteapp.repository

import com.example.jcmynoteapp.data.NoteDatabaseDao
import com.example.jcmynoteapp.models.Note
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.conflate
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class NoteRepository @Inject constructor(
    private val noteDatabaseDao: NoteDatabaseDao
) {
    fun addNote(note: Note) = noteDatabaseDao.insert(note)
    fun updateNote(note: Note) = noteDatabaseDao.update(note)
    fun deleteNote(note: Note) = noteDatabaseDao.deleteNote(note)
    fun deleteAllNotes() = noteDatabaseDao.deleteAll()
    fun getAllNotes(): Flow<List<Note>> =
        noteDatabaseDao.getNotes().flowOn(Dispatchers.IO).conflate()
}