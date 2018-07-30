package com.tahamalas.notetakingapp.datalayer.db

import com.tahamalas.notetakingapp.datalayer.Note
import io.reactivex.Observable
import javax.inject.Inject

class AppRepository @Inject constructor(private val appDao: AppDao) : DbHelper {
    override fun deleteNote(note: Note) = appDao.deleteNote(note)

    override fun updateNotes(note: Note) = appDao.updateNotes(note)

    override fun getNotes(): Observable<List<Note>> = appDao.getNotes().toObservable()

    override fun getNoteByDate(date: String): Observable<Note> = appDao.getNotesByDate(date).toObservable()

}