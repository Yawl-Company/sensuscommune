package com.yawl.vermont

import android.app.Application
import com.yawl.vermont.di.ApplicationComponent
import com.yawl.vermont.di.DaggerApplicationComponent

class Application : Application() {
    private val component: ApplicationComponent by lazy {
        DaggerApplicationComponent.builder().build()
    }

    override fun onCreate() {
        super.onCreate()
        component.inject(this)
    }
}
