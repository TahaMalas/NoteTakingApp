package com.tahamalas.notetakingapp.presentationlayer.display

import android.support.annotation.StringRes
import com.tahamalas.notetakingapp.base.IBaseView
import com.tahamalas.notetakingapp.datalayer.Note

interface IDisplayView : IBaseView {

    fun displayNotes(note: List<Note>)

    fun showLoading()

    fun hideLoading()

    fun showMessage(@StringRes resId: Int) {
        showMessage(getContext().getString(resId))
    }

    fun showMessage(error: String)

}