package com.yawl.compose

import org.gradle.api.Plugin
import org.gradle.api.Project

class AndroidLibraryComposeConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            plugins.apply("com.android.library")
            plugins.apply(AndroidBaseComposeConventionPlugin::class.java)
        }
    }
}
