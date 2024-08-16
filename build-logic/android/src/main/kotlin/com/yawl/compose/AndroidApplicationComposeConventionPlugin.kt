package com.yawl.compose

import org.gradle.api.Plugin
import org.gradle.api.Project

class AndroidApplicationComposeConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            plugins.apply("com.android.application")
            plugins.apply(AndroidBaseComposeConventionPlugin::class.java)
        }
    }
}
