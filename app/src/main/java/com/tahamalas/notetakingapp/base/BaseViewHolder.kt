package com.tahamalas.notetakingapp.base

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.View
import butterknife.ButterKnife

abstract class BaseViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    protected val context: Context

    init {
        ButterKnife.bind(this, itemView)
        context = itemView.context
    }

}
