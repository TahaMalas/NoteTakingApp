package com.appagroup.domain.repository

import com.appagroup.domain.domainmodel.Note

interface INoteRepository {

    fun deleteNotes()

    fun deleteNote(note: Note)

    fun updateNotes(note: Note)

    fun updateNotes(notes: List<Note>)

    fun getNotes()

}
