package com.tahamalas.notetakingapp.presentationlayer.display

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.tahamalas.notetakingapp.R
import com.tahamalas.notetakingapp.base.BaseAdapter
import com.tahamalas.notetakingapp.datalayer.Note
import com.tahamalas.notetakingapp.utils.OnStartDragListener
import kotlinx.android.synthetic.main.layout_item.view.*

class DisplayAdapter(noteList: MutableList<Note>, dragStartListener: OnStartDragListener) : BaseAdapter<Note, DisplayAdapter.ViewHolder>(noteList, dragStartListener) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
            ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.layout_item, parent, false))

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount() = items.size

    class ViewHolder(val view: View) : BaseViewHolder(view) {
        fun bind(note: Note) {
            view.title.text = note.name
            view.detail.text = note.description
        }
    }

}
