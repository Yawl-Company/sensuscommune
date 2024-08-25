package com.yawl

import org.gradle.api.Plugin
import org.gradle.api.Project

class DaggerConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            plugins.apply(KaptConventionPlugin::class.java)
            dependencies.add("implementation", libs.dagger.base.get())
            // change to ksp when supported
            dependencies.add("kapt", libs.dagger.compiler.get())
        }
    }
}
