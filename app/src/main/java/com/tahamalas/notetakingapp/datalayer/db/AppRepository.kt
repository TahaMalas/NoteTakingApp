package com.tahamalas.notetakingapp.datalayer.db

import com.tahamalas.notetakingapp.datalayer.Note
import io.reactivex.Completable
import io.reactivex.Observable
import javax.inject.Inject

class AppRepository @Inject constructor(private val appDao: AppDao) : DbHelper {

    override fun deleteNotes() = Completable.fromAction { appDao.deleteNotes() }.toObservable<Any>()

    override fun deleteNote(note: Note) = Completable.fromAction { appDao.deleteNote(note) }.toObservable<Any>()

    override fun updateNotes(noteList: List<Note>) = Completable.fromAction { appDao.updateNotes(noteList) }.toObservable<Any>()

    override fun updateNote(note: Note) = Completable.fromAction { appDao.updateNote(note) }.toObservable<Any>()

    override fun getNotes(): Observable<List<Note>> = appDao.getNotes().toObservable()

    override fun getNoteByDate(date: String): Observable<Note> = appDao.getNotesByDate(date).toObservable()

}