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
import com.tahamalas.notetakingapp.utils.OnStartDragListener
import kotlinx.android.synthetic.main.activity_detail.*
import java.util.*
import com.tahamalas.notetakingapp.utils.SimpleItemTouchHelper


class DisplayActivity : BaseActivity<IDisplayPresenter>(), IDisplayView, OnStartDragListener {

    private val items = mutableListOf<Note>()
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
        items.addAll(note)
    }

    override fun showMessage(error: String) {
        Toast.makeText(this, error, Toast.LENGTH_LONG).show()
    }

    override fun onStartDrag(viewHolder: RecyclerView.ViewHolder) {
        itemTouchHelper.startDrag(viewHolder)
    }

    override fun initViews() {
        displayAdapter = DisplayAdapter(items, this)
        recyclerView.adapter = displayAdapter
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.addItemDecoration(DividerItemDecoration(this, LinearLayout.VERTICAL))
        loadDummyNotes()

        val callback = SimpleItemTouchHelper(displayAdapter)
        itemTouchHelper = ItemTouchHelper(callback)
        itemTouchHelper.attachToRecyclerView(recyclerView)

        displayAdapter.notifyDataSetChanged()
        presenter.loadNotes()
        fab.setOnClickListener { startActivity(Intent(this, AddActivity::class.java)) }
    }

    override fun instantiatePresenter(): DisplayPresenter = DisplayPresenter(this)

    override fun getContentView() = R.layout.activity_detail

    private fun loadDummyNotes() {
        items.add(Note(Calendar.getInstance().timeInMillis, "Note1", "Note1 description"))
        items.add(Note(Calendar.getInstance().timeInMillis, "Note2", "Note2 description"))
        items.add(Note(Calendar.getInstance().timeInMillis, "Note3", "Note3 description"))
        items.add(Note(Calendar.getInstance().timeInMillis, "Note4", "Note4 description"))
    }

}
