package com.example.tbg.data.app_lifecycle

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ApplicationLifecycleState
@Inject constructor() {

    var isForeground: Boolean = false

}