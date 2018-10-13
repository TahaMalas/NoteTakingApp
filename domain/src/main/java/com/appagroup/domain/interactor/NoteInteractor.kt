package com.appagroup.domain.interactor

import com.appagroup.domain.domainmodel.Note
import com.appagroup.domain.domainmodel.Result
import com.appagroup.domain.repository.INoteRepository

class NoteInteractor(val noteRepository: INoteRepository) {

    suspend fun getNotes(): Result<Exception, Note> {
        TODO("return notes")
    }

    suspend fun deleteNotes(): Result<Exception, Boolean> {

    }

    suspend fun deleteNote(note: Note) : Result<Exception, Boolean> {

    }

    suspend fun updateNote(note: Note) : Result<Exception, Boolean> {

    }

    suspend fun updateNotes(notes: List<Note>) : Result<Exception, Boolean> {

    }
*
}

