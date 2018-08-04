package com.tahamalas.notetakingapp.domainlayer.display

import com.tahamalas.notetakingapp.R
import com.tahamalas.notetakingapp.base.BasePresenter
import com.tahamalas.notetakingapp.datalayer.Note
import com.tahamalas.notetakingapp.datalayer.db.DbHelper
import com.tahamalas.notetakingapp.presentationlayer.display.IDisplayView
import com.tahamalas.notetakingapp.utils.DisposableManager
import io.reactivex.Observer
import io.reactivex.disposables.Disposable
import javax.inject.Inject

class DisplayPresenter(displayView: IDisplayView) : BasePresenter<IDisplayView>(displayView), IDisplayPresenter, Observer<List<Note>> {

    @Inject
    lateinit var appRepository: DbHelper

    override fun retrieveView(): IDisplayView = view

    override fun loadNotes() {
        view.showLoading()
        subscribe(appRepository.getNotes(), this)
    }

    override fun onComplete() {

    }

    override fun onSubscribe(d: Disposable) {
        DisposableManager.add(d)
    }

    override fun onNext(t: List<Note>) {
        println("DisplayPresenter: SOMETHING SIZE ${t.size}")
        with(view) {
            hideLoading()
            displayNotes(t)
        }
    }

    override fun onError(e: Throwable) {
        println(e.message.toString())
        view.showMessage(R.string.somethingWentWrong)
    }

    override fun deleteNote(note: Note) {
        subscribe(appRepository.deleteNote(note), object : Observer<Any> {
            override fun onComplete() {
                view.showMessage("Note deleted")
            }

            override fun onSubscribe(d: Disposable) {
                DisposableManager.add(d)
            }

            override fun onNext(t: Any) {

            }

            override fun onError(e: Throwable) {
                view.showMessage(e.message!!)
            }
        })
    }

    override fun updateNotes(notes: List<Note>) {
        subscribe(appRepository.deleteNotes(), object : Observer<Any> {
            override fun onComplete() {
                println("DisplayPresenter: Notes deleted")
                view.showMessage("DELETED")
                updateNotess(notes)
            }

            override fun onSubscribe(d: Disposable) {
                DisposableManager.add(d)
            }

            override fun onNext(t: Any) {

            }

            override fun onError(e: Throwable) {
                view.showMessage(e.message!!)
            }
        })

    }

    override fun updateNotess(notes: List<Note>) {
        subscribe(appRepository.updateNotes(notes), object : Observer<Any> {
            override fun onComplete() {
                println("DisplayPresenter: Notes inserted")
                view.showMessage("INSERTED")
            }

            override fun onSubscribe(d: Disposable) {
                DisposableManager.add(d)
            }

            override fun onNext(t: Any) {

            }

            override fun onError(e: Throwable) {
                view.showMessage(e.message!!)
            }
        })
    }

}
