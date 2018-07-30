package com.tahamalas.notetakingapp.app

import android.app.Activity
import android.app.Application
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import javax.inject.Inject

class App : Application(), HasActivityInjector {

    @Inject
    lateinit var activityInjector: DispatchingAndroidInjector<Activity>

    override fun onCreate() {
        super.onCreate()
        instance = this
    }

    @Inject
    override fun activityInjector(): AndroidInjector<Activity> = activityInjector

    companion object {
        @get:Synchronized
        var instance: App? = null
            private set
    }
}
