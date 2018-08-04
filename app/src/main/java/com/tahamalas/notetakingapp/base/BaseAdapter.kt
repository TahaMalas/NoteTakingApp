package com.tahamalas.notetakingapp.base

import android.graphics.Color
import android.support.annotation.CallSuper
import android.support.v7.widget.RecyclerView
import android.view.MotionEvent
import android.view.View
import android.support.v4.view.MotionEventCompat
import com.tahamalas.notetakingapp.utils.*

abstract class BaseAdapter<T, V: BaseAdapter.BaseViewHolder>(protected val items: MutableList<T>, protected val dragStartListener: OnStartDragListener) : RecyclerView.Adapter<V>(), ItemTouchHelperAdapter {

    @CallSuper
    override fun onBindViewHolder(holder: V, position: Int) {

    }

    private fun swapItems(fromPosition: Int, toPosition: Int) {
        if (fromPosition < toPosition) {
            for (i in fromPosition until toPosition) {
                items[i] = items.set(i+1, items[i])
            }
        } else {
            for (i in fromPosition downTo toPosition + 1) {
                items[i] = items.set(i-1, items[i])
            }
        }

        notifyItemMoved(fromPosition, toPosition)
    }

    @CallSuper
    override fun onItemDismiss(position: Int) {
        items.removeAt(position)
        notifyItemRemoved(position)
    }

    @CallSuper
    override fun onItemMove(fromPosition: Int, toPosition: Int): Boolean {
        swapItems(fromPosition, toPosition)
        return true
    }

    open class BaseViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), ItemTouchHelperViewHolder {

        override fun onItemSelected() {
            itemView.setBackgroundColor(Color.LTGRAY)
        }

        override fun onItemClear() {
            itemView.setBackgroundColor(0)
        }
    }

}
