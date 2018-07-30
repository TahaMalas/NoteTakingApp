package com.tahamalas.notetakingapp.presentationlayer.add

import android.widget.Toast
import com.tahamalas.notetakingapp.R
import com.tahamalas.notetakingapp.base.BaseActivity
import com.tahamalas.notetakingapp.domainlayer.add.AddPresenter
import com.tahamalas.notetakingapp.domainlayer.add.IAddPresenter

class AddActivity : BaseActivity<IAddPresenter>(), IAddView {

    override fun instantiatePresenter(): IAddPresenter = AddPresenter(this)

    override fun initViews() {
    }

    override fun getContentView(): Int = R.layout.activity_detail


    override fun added() {
        Toast.makeText(this, "ADDED", Toast.LENGTH_LONG).show()
    }

}