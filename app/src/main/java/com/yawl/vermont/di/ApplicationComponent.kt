package com.yawl.vermont.di

import android.app.Application
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ApplicationModule::class])
interface ApplicationComponent {
    fun inject(application: Application)
}
