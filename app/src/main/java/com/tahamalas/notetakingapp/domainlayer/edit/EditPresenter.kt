package com.tahamalas.notetakingapp.domainlayer.edit

import com.tahamalas.notetakingapp.base.BasePresenter
import com.tahamalas.notetakingapp.datalayer.Note
import com.tahamalas.notetakingapp.datalayer.db.DbHelper
import com.tahamalas.notetakingapp.presentationlayer.edit.IEditView
import com.tahamalas.notetakingapp.utils.DisposableManager
import io.reactivex.Observer
import io.reactivex.disposables.Disposable
import javax.inject.Inject

class EditPresenter(editView: IEditView): BasePresenter<IEditView>(editView), IEditPresenter, Observer<Any>{

    @Inject
    lateinit var appRepository: DbHelper

    override fun retrieveView(): IEditView = view

    override fun editNote(oldNote: Note, title: String, description: String) {
        val newNote = Note(oldNote.date, title, description)
        subscribe(appRepository.updateNote(newNote), this)
    }

    override fun onComplete() {
        view.onNoteEdited()
    }

    override fun onSubscribe(d: Disposable) {
        DisposableManager.add(d)
    }

    override fun onNext(t: Any) {

    }

    override fun onError(e: Throwable) {
        view.showMessage(e.message!!)
    }
}