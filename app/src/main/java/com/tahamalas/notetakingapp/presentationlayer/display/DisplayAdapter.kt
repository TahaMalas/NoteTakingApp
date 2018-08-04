package com.tahamalas.notetakingapp.presentationlayer.display

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.tahamalas.notetakingapp.R
import com.tahamalas.notetakingapp.base.BaseAdapter
import com.tahamalas.notetakingapp.datalayer.Note
import com.tahamalas.notetakingapp.utils.ItemTouchHelperView
import com.tahamalas.notetakingapp.utils.OnItemClickListener
import com.tahamalas.notetakingapp.utils.OnStartDragListener
import kotlinx.android.synthetic.main.layout_item.view.*

class DisplayAdapter(noteList: MutableList<Note>, dragStartListener: OnStartDragListener, private val itemTouchHelperView: ItemTouchHelperView, val itemClickListener: OnItemClickListener) : BaseAdapter<Note, DisplayAdapter.ViewHolder>(noteList, dragStartListener) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
            ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.layout_item, parent, false))

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        super.onBindViewHolder(holder, position)
        holder.bind(items[position], itemClickListener)
    }

    override fun getItemCount() = items.size

    class ViewHolder(val view: View) : BaseViewHolder(view) {
        fun bind(note: Note, onItemClickListener: OnItemClickListener) {
            view.title.text = note.name
            view.detail.text = note.description
            itemView.setOnClickListener { onItemClickListener.onItemClickListener(adapterPosition) }
        }
    }

    override fun onItemDismiss(position: Int) {
        itemTouchHelperView.onItemDeleted(items[position])
        super.onItemDismiss(position)
    }

    override fun onItemMove(fromPosition: Int, toPosition: Int): Boolean {
        super.onItemMove(fromPosition, toPosition)
        itemTouchHelperView.onItemMoved(items)
        return true
    }
}
