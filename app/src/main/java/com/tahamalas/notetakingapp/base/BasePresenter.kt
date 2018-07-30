package com.tahamalas.notetakingapp.base

import com.tahamalas.notetakingapp.di.component.DaggerPresenterInjector
import com.tahamalas.notetakingapp.di.component.PresenterInjector
import com.tahamalas.notetakingapp.di.module.ApplicationModule
import com.tahamalas.notetakingapp.domainlayer.add.AddPresenter
import com.tahamalas.notetakingapp.domainlayer.display.DisplayPresenter
import com.tahamalas.notetakingapp.utils.DisposableManager
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * Base presenter any presenter of the application must extend. It provides initial injections and
 * required methods.
 * @param V the type of the View the presenter is based on
 * @property view the view the presenter is based on
 * @constructor Injects the required dependencies
 */
open class BasePresenter<out V : IBaseView>(protected val view: V) : IBasePresenter<V> {

    private val injector: PresenterInjector = DaggerPresenterInjector
            .builder()
            .baseView(view)
            .applicationModule(ApplicationModule)
            .build()

    init {
        inject()
    }

    override fun <T> subscribe(observable: Observable<T>, observer: Observer<T>) {
        observable
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(observer)
    }

    override fun unsubscribe() {
        DisposableManager.dispose()
    }

    /**
     * This method may be called when the presenter view is created
     */
    open fun onViewCreated() {}

    /**
     * This method may be called when the presenter view is destroyed
     */
    open fun onViewDestroyed() {
        DisposableManager.dispose()
    }

    /**
     * Injects the required dependencies
     */
    private fun inject() {
        when (this) {
            is DisplayPresenter -> injector.inject(this)
            is AddPresenter -> injector.inject(this)
        }
    }

    override fun retrieveView(): V = view

}