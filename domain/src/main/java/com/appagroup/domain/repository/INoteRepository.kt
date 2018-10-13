package com.appagroup.domain.repository

import com.appagroup.domain.domainmodel.Note
import com.appagroup.domain.domainmodel.Result

interface INoteRepository {

    fun deleteNotes(): Result<Exception, Boolean>

    fun deleteNote(note: Note): Result<Exception, Boolean>

    fun updateNotes(note: Note): Result<Exception, Boolean>

    fun updateNotes(notes: List<Note>): Result<Exception, Boolean>

    fun getNotes(): Result<Exception, List<Note>>

}
