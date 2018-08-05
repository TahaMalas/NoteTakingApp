package com.tahamalas.notetakingapp.domainlayer.display

import com.tahamalas.notetakingapp.base.IBasePresenter
import com.tahamalas.notetakingapp.datalayer.Note
import com.tahamalas.notetakingapp.presentationlayer.display.IDisplayView

interface IDisplayPresenter : IBasePresenter<IDisplayView> {

    fun loadNotes()

    fun deleteNote(note: Note)

    fun updateNotes(notes: List<Note>)

}