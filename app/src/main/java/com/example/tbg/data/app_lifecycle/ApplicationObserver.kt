package com.example.tbg.data.app_lifecycle

import android.util.Log
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.LifecycleObserver
import javax.inject.Inject

class ApplicationObserver
@Inject constructor(
    private val state: ApplicationLifecycleState
) : LifecycleObserver {

    private val lifecycleEventObserver = LifecycleEventObserver { source, event ->
        if (event == Lifecycle.Event.ON_START) {
            fun onForeground() {
                Log.e("ApplicationObserver", "!!!App goes to foreground")
                // App goes to foreground
                state.isForeground = true
            }
        } else if (event == Lifecycle.Event.ON_STOP) {
            fun onBackground() {
                Log.e("ApplicationObserver", "!!!App goes to background")
                // App goes to background
                state.isForeground = false
            }
        }
    }
}