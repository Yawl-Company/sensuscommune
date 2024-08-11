package com.yawl

import org.gradle.api.Plugin
import org.gradle.api.Project

class DaggerConventionPlugin: Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            plugins.apply(KspConventionPlugin::class.java)
            dependencies.add("implementation", libs.dagger.base.get())
            dependencies.add("ksp", libs.dagger.compiler.get())
        }
    }
}