package com.tahamalas.notetakingapp.datalayer.db

import android.arch.persistence.room.*
import android.arch.persistence.room.OnConflictStrategy.REPLACE
import com.tahamalas.notetakingapp.datalayer.Note
import io.reactivex.Flowable
import io.reactivex.Single

@Dao
interface AppDao {

    @Query("DELETE FROM note")
    fun deleteNotes()

    @Delete
    fun deleteNote(note: Note)

    @Insert(onConflict = REPLACE)
    fun updateNote(note: Note)

    @Insert(onConflict = REPLACE)
    fun updateNotes(notesList: List<Note>)

    @Query("SELECT * FROM note")
    fun getNotes(): Single<List<Note>>

    @Query("SELECT * FROM note WHERE date = :date")
    fun getNotesByDate(date: String): Flowable<Note>

}
