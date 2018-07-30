package com.tahamalas.notetakingapp.presentationlayer.display

import android.widget.Toast
import com.tahamalas.notetakingapp.R
import com.tahamalas.notetakingapp.base.BaseActivity
import com.tahamalas.notetakingapp.datalayer.Note
import com.tahamalas.notetakingapp.domainlayer.display.DisplayPresenter
import com.tahamalas.notetakingapp.domainlayer.display.IDisplayPresenter


class DisplayActivity : BaseActivity<IDisplayPresenter>(), IDisplayView {

    override fun showLoading() {
        println("DisplayActivity: ShowLoading")
    }

    override fun hideLoading() {
        println("DisplayActivity: HideLoading")
    }

    override fun displayNotes(note: List<Note>) {
        println("DisplayActivity: ${note.size}")
    }

    override fun showMessage(error: String) {
        Toast.makeText(this, error, Toast.LENGTH_LONG).show()
    }

    override fun initViews() {
        presenter.loadNotes()
    }

    override fun instantiatePresenter(): DisplayPresenter {
        return DisplayPresenter(this)
    }

    override fun getContentView(): Int {
        return R.layout.activity_main
    }
}
