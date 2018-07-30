package com.tahamalas.notetakingapp.base

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.annotation.CallSuper
import android.support.v7.app.AppCompatActivity

abstract class BaseActivity<P : IBasePresenter<IBaseView>> : IBaseView, AppCompatActivity() {

    protected lateinit var presenter: P

    override fun getContext(): Context = this

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getContentView())

        presenter = instantiatePresenter()

        onViewReady(savedInstanceState, intent)
    }

    @CallSuper
    protected open fun onViewReady(savedInstanceState: Bundle?, intent: Intent?) {
        //To be used by child activities
        initViews()
    }

    protected fun showBackArrow() {
        supportActionBar?.apply {
            let {
                setDisplayShowHomeEnabled(true)
                setDisplayShowHomeEnabled(true)
            }
        }
    }

    protected abstract fun instantiatePresenter(): P

    protected abstract fun initViews()

    protected abstract fun getContentView(): Int

}
