package com.yawl.compose

import com.yawl.libs
import org.gradle.api.Plugin
import org.gradle.api.Project

class AndroidApplicationComposeConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            plugins.apply(libs.plugins.android.application.get().pluginId)
            plugins.apply(AndroidBaseComposeConventionPlugin::class.java)
        }
    }
}
