package com.yawl

import org.gradle.api.Plugin
import org.gradle.api.Project

class KspConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            plugins.apply("com.google.devtools.ksp")
        }
    }
}
