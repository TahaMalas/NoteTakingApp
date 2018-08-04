package com.tahamalas.notetakingapp.presentationlayer.display

import android.content.Intent
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.helper.ItemTouchHelper
import android.view.View.GONE
import android.view.View.VISIBLE
import android.widget.LinearLayout
import android.widget.Toast
import com.tahamalas.notetakingapp.R
import com.tahamalas.notetakingapp.base.BaseActivity
import com.tahamalas.notetakingapp.datalayer.Note
import com.tahamalas.notetakingapp.domainlayer.display.DisplayPresenter
import com.tahamalas.notetakingapp.domainlayer.display.IDisplayPresenter
import com.tahamalas.notetakingapp.presentationlayer.add.AddActivity
import com.tahamalas.notetakingapp.presentationlayer.edit.EditActivity
import com.tahamalas.notetakingapp.utils.*
import kotlinx.android.synthetic.main.activity_detail.*

class DisplayActivity : BaseActivity<IDisplayPresenter>(), IDisplayView, OnStartDragListener, ItemTouchHelperView, OnItemClickListener {


    private var items = mutableListOf<Note>()
    private lateinit var displayAdapter: DisplayAdapter
    private lateinit var itemTouchHelper: ItemTouchHelper

    override fun showLoading() {
        println("DisplayActivity: ShowLoading")
        progressBar.visibility = VISIBLE
    }

    override fun hideLoading() {
        println("DisplayActivity: HideLoading")
        progressBar.visibility = GONE
    }

    override fun displayNotes(note: List<Note>) {
        println("DisplayActivity: ${note.size}")
        if (note.isNotEmpty()) {
            println(note[0])
        }
        if (items.isNotEmpty()) {
            items.clear()
        }
        items.addAll(note)
        displayAdapter.notifyItemRangeChanged(0, items.count())
    }

    override fun showMessage(error: String) {
        Toast.makeText(this, error, Toast.LENGTH_LONG).show()
    }

    override fun onStartDrag(viewHolder: RecyclerView.ViewHolder) {
        itemTouchHelper.startDrag(viewHolder)
    }

    override fun initViews() {
        displayAdapter = DisplayAdapter(items, this, this, this)
        recyclerView.adapter = displayAdapter
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.addItemDecoration(DividerItemDecoration(this, LinearLayout.VERTICAL))

        val callback = SimpleItemTouchHelper(this, displayAdapter)
        itemTouchHelper = ItemTouchHelper(callback)
        itemTouchHelper.attachToRecyclerView(recyclerView)

        presenter.loadNotes()
        fab.setOnClickListener { startActivity(Intent(this, AddActivity::class.java)) }
    }

    override fun instantiatePresenter(): DisplayPresenter = DisplayPresenter(this)

    override fun getContentView() = R.layout.activity_detail

    override fun onItemMoved(newListOfNote: MutableList<Note>) {
        items = newListOfNote
        presenter.updateNotes(items)
    }

    override fun onItemDeleted(note: Note) {
        presenter.deleteNote(note)
    }

    override fun onItemClickListener(position: Int) {
        val intent = Intent(this, EditActivity::class.java)
        val note = items[position]
        intent.putExtra("time", note.date)
        intent.putExtra("title", note.name)
        intent.putExtra("description", note.description)
        startActivity(intent)
    }

    override fun onStart() {
        super.onStart()
        //OnItemAdded
        RxBus.listen(MessageEvent::class.java).subscribe { messageEvent ->
            println(messageEvent.eventId)
            when (messageEvent.eventId) {
                MessageEvent.ADDED_EVENT, MessageEvent.EDITED_EVENT -> {
                    presenter.loadNotes()
                    println("SOMETHING ${messageEvent.eventId}")
                }
            }
        }
    }
}
