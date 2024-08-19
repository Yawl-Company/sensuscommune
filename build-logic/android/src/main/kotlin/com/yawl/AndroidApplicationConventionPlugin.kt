package com.yawl

import com.yawl.android.KotlinAndroidBaseConventionPlugin
import org.gradle.api.Plugin
import org.gradle.api.Project

class AndroidApplicationConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            plugins.apply(libs.plugins.android.application.get().pluginId)
            plugins.apply(AndroidBaseConventionPlugin::class.java)
            plugins.apply(KotlinAndroidBaseConventionPlugin::class.java)
        }
    }
}
