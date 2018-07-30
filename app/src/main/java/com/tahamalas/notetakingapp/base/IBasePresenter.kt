package com.tahamalas.notetakingapp.base

import io.reactivex.Observable
import io.reactivex.Observer

interface IBasePresenter<out V : IBaseView> {

    fun <T> subscribe(observable: Observable<T>, observer: Observer<T>)

    fun unsubscribe()

    fun retrieveView(): V

}