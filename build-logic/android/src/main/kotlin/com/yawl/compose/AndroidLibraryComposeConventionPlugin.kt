package com.yawl.compose

import com.yawl.libs
import org.gradle.api.Plugin
import org.gradle.api.Project

class AndroidLibraryComposeConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            plugins.apply(libs.plugins.android.library.get().pluginId)
            plugins.apply(AndroidBaseComposeConventionPlugin::class.java)
        }
    }
}
