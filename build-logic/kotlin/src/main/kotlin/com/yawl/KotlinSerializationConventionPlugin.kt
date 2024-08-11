package com.yawl

import org.gradle.api.Plugin
import org.gradle.api.Project

class KotlinSerializationConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            plugins.apply("org.jetbrains.kotlin.plugin.serialization")

            dependencies.add("implementation", libs.kotlin.serialization.json.get())
        }
    }
}
