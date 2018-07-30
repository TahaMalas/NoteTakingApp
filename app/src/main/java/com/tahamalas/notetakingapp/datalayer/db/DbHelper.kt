package com.tahamalas.notetakingapp.datalayer.db

import com.tahamalas.notetakingapp.datalayer.Note
import io.reactivex.Observable

interface DbHelper {
    fun deleteNote(note: Note)

    fun updateNotes(note: Note)

    fun getNotes(): Observable<List<Note>>

    fun getNoteByDate(date: String): Observable<Note>

}