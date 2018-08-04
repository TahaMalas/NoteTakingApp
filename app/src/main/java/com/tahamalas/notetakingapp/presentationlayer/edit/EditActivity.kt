package com.tahamalas.notetakingapp.presentationlayer.edit

import android.widget.Toast
import com.tahamalas.notetakingapp.R
import com.tahamalas.notetakingapp.base.BaseActivity
import com.tahamalas.notetakingapp.datalayer.Note
import com.tahamalas.notetakingapp.domainlayer.edit.EditPresener
import com.tahamalas.notetakingapp.domainlayer.edit.IEditPresenter
import com.tahamalas.notetakingapp.utils.MessageEvent
import com.tahamalas.notetakingapp.utils.RxBus
import kotlinx.android.synthetic.main.activity_edit.*

class EditActivity : BaseActivity<IEditPresenter>() , IEditView {

    lateinit var note: Note

    override fun onNoteEdited() {
        Toast.makeText(this, "EDITED", Toast.LENGTH_LONG).show()
        onBackPressed()
        RxBus.publish(MessageEvent(MessageEvent.ADDED_EVENT))
    }

    override fun showMessage(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    override fun instantiatePresenter() = EditPresener(this)

    override fun initViews() {
        if (intent.hasExtra("time") and intent.hasExtra("title") and intent.hasExtra("description")) {
            note = Note(intent.getLongExtra("time", 0), intent.getStringExtra("title"), intent.getStringExtra("description"))
            titleee.setText(note.name)
            description.setText(note.description)
        } else {
            note = Note(0, "Note did not load", "")
        }
        changeAppBarTitle("Edit Note")
        showBackArrow()
        fab.setOnClickListener { presenter.editNote(note, titleee.text.toString(), description.text.toString()) }
    }

    override fun getContentView() = R.layout.activity_edit

}