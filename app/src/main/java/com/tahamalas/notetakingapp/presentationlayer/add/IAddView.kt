package com.tahamalas.notetakingapp.presentationlayer.add

import com.tahamalas.notetakingapp.base.IBaseView

interface IAddView : IBaseView {

    fun added()

    fun error(message: String)

}