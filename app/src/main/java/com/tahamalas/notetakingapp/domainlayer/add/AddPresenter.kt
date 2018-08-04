package com.tahamalas.notetakingapp.domainlayer.add

import com.tahamalas.notetakingapp.base.BasePresenter
import com.tahamalas.notetakingapp.datalayer.Note
import com.tahamalas.notetakingapp.datalayer.db.AppRepository
import com.tahamalas.notetakingapp.presentationlayer.add.IAddView
import com.tahamalas.notetakingapp.utils.DisposableManager
import io.reactivex.Observer
import io.reactivex.disposables.Disposable
import java.util.*
import javax.inject.Inject

class AddPresenter(addView: IAddView) : BasePresenter<IAddView>(addView), IAddPresenter, Observer<Any> {

    @Inject
    lateinit var appRepository: AppRepository

    override fun addNote(name: String, detail: String) {
        val note = Note(Calendar.getInstance().timeInMillis, name, detail)
        subscribe(appRepository.updateNote(note), this)
    }

    override fun onComplete() {
        view.added()
    }

    override fun onSubscribe(d: Disposable) {
        DisposableManager.add(d)
    }

    override fun onNext(t: Any) {

    }

    override fun onError(e: Throwable) {
        view.error(e.message ?: "Something went wrong")
    }

}
