package com.tahamalas.notetakingapp.datalayer.db

import com.tahamalas.notetakingapp.datalayer.Note
import io.reactivex.Observable

interface DbHelper {

    fun deleteNotes(): Observable<Any>

    fun deleteNote(note: Note): Observable<Any>

    fun updateNote(note: Note): Observable<Any>

    fun updateNotes(noteList: List<Note>): Observable<Any>

    fun getNotes(): Observable<List<Note>>

    fun getNoteByDate(date: String): Observable<Note>

}