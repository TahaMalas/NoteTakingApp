package com.tahamalas.notetakingapp.domainlayer.add

import com.tahamalas.notetakingapp.base.IBasePresenter
import com.tahamalas.notetakingapp.presentationlayer.add.IAddView

interface IAddPresenter : IBasePresenter<IAddView> {

    fun addNote(name: String, detail: String)

}