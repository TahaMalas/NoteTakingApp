package com.tahamalas.notetakingapp.base

import android.content.Context

/**
 * Base view any view must implement.
 */

interface IBaseView {

    /**
     * Returns the context in which the application is running.
     * @return the context in which the application is running
     */
    fun getContext(): Context

}