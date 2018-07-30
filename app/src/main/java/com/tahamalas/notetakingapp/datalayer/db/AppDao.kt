package com.tahamalas.notetakingapp.datalayer.db

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Delete
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy.REPLACE
import android.arch.persistence.room.Query
import com.tahamalas.notetakingapp.datalayer.Note
import io.reactivex.Flowable

@Dao
interface AppDao {

    @Delete
    fun deleteNote(note: Note)

    @Insert(onConflict = REPLACE)
    fun updateNotes(note: Note)

    @Query("SELECT * FROM note")
    fun getNotes(): Flowable<List<Note>>

    @Query("SELECT * FROM note WHERE date = :date")
    fun getNotesByDate(date: String): Flowable<Note>

}
