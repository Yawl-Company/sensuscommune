package com.yawl

import org.gradle.api.Plugin
import org.gradle.api.Project

// delete when all frameworks support ksp2
class KaptConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            plugins.apply(libs.plugins.kapt.get().pluginId)
        }
    }
}
