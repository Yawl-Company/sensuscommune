package com.yawl.sensuscommune

import android.app.Application
import com.yawl.sensuscommune.di.ApplicationComponent
import com.yawl.sensuscommune.di.DaggerApplicationComponent

class SensusCommuneApplication : Application() {
    private val component: ApplicationComponent by lazy {
        DaggerApplicationComponent.builder().build()
    }

    override fun onCreate() {
        super.onCreate()
        component.inject(this)
    }
}
