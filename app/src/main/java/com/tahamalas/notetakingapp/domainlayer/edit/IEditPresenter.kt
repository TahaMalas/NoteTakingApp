package com.tahamalas.notetakingapp.domainlayer.edit

import com.tahamalas.notetakingapp.base.IBasePresenter
import com.tahamalas.notetakingapp.datalayer.Note
import com.tahamalas.notetakingapp.presentationlayer.edit.IEditView

interface IEditPresenter : IBasePresenter<IEditView> {

    fun editNote(oldNote: Note, title: String, description: String)

}