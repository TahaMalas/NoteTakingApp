package com.appagroup.domain.interactor

import com.appagroup.common.coroutines.ICoroutineContextProvider
import com.appagroup.domain.domainmodel.Note
import com.appagroup.domain.domainmodel.Result
import com.appagroup.domain.repository.INoteRepository

class NoteInteractor(val noteRepository: INoteRepository,
                     val coroutineContextProvider: ICoroutineContextProvider) {

    suspend fun getNotes(): Result<Exception, List<Note>> {
        TODO("return notes")
    }

    suspend fun deleteNotes(): Result<Exception, Boolean> {
        TODO("return notes")
    }

    suspend fun deleteNote(note: Note): Result<Exception, Boolean> {
        TODO("return notes")
    }

    suspend fun updateNote(note: Note): Result<Exception, Boolean> {
        TODO("return notes")
    }

    suspend fun updateNotes(notes: List<Note>): Result<Exception, Boolean> {
        TODO("return notes")
    }
}

