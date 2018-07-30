package com.tahamalas.notetakingapp.domainlayer.add

import com.tahamalas.notetakingapp.base.BasePresenter
import com.tahamalas.notetakingapp.datalayer.Note
import com.tahamalas.notetakingapp.datalayer.db.AppRepository
import com.tahamalas.notetakingapp.datalayer.db.DbHelper
import com.tahamalas.notetakingapp.presentationlayer.add.IAddView
import javax.inject.Inject

class AddPresenter(addView: IAddView) : BasePresenter<IAddView>(addView), IAddPresenter {

    @Inject
    lateinit var appRepository: DbHelper

    override fun addNote(name: String, detail: String) {
        val note = Note("6776",name, detail)
        appRepository.updateNotes(note)
        view.added()
    }

}