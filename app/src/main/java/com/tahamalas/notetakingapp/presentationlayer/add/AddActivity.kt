package com.tahamalas.notetakingapp.presentationlayer.add

import android.widget.Toast
import com.tahamalas.notetakingapp.R
import com.tahamalas.notetakingapp.base.BaseActivity
import com.tahamalas.notetakingapp.domainlayer.add.AddPresenter
import com.tahamalas.notetakingapp.domainlayer.add.IAddPresenter
import com.tahamalas.notetakingapp.utils.MessageEvent
import com.tahamalas.notetakingapp.utils.RxBus
import kotlinx.android.synthetic.main.activity_add.*

class AddActivity : BaseActivity<IAddPresenter>(), IAddView {

    override fun instantiatePresenter(): IAddPresenter = AddPresenter(this)

    override fun initViews() {
        changeAppBarTitle("Add Note")
        showBackArrow()
        fab.setOnClickListener { presenter.addNote(titlee.text.toString(), description.text.toString()) }
    }

    override fun getContentView(): Int = R.layout.activity_add

    override fun added() {
        Toast.makeText(this, "ADDED", Toast.LENGTH_LONG).show()
        onBackPressed()
        RxBus.publish(MessageEvent(MessageEvent.ADDED_EVENT))
    }

    override fun error(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }

}
