package com.example.tbg

import android.app.Application
import android.content.Context
import android.content.res.Configuration
import androidx.lifecycle.ProcessLifecycleOwner
import com.example.tbg.data.app_lifecycle.ApplicationObserver
import dagger.android.HasAndroidInjector
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import javax.inject.Inject

class App : Application(), HasAndroidInjector {

    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Any>

    @Inject
    lateinit var lifecycleListener: ApplicationObserver

    override fun onCreate() {
        super.onCreate()
        AppInjector.init(this)

        ProcessLifecycleOwner.get()
            .lifecycle
            .addObserver(lifecycleListener)
    }

    override fun androidInjector(): AndroidInjector<Any> = dispatchingAndroidInjector
}