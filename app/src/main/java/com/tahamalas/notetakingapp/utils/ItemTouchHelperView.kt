package com.tahamalas.notetakingapp.utils

import com.tahamalas.notetakingapp.datalayer.Note

interface ItemTouchHelperView {

    fun onItemMoved(newListOfNote: MutableList<Note>)

    fun onItemDeleted(note: Note)
}