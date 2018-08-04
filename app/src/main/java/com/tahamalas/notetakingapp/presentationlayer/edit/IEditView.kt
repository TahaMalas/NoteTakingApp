package com.tahamalas.notetakingapp.presentationlayer.edit

import com.tahamalas.notetakingapp.base.IBaseView

interface IEditView : IBaseView {

    fun onNoteEdited()

    fun showMessage(message: String)

}