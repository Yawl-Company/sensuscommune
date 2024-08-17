package com.yawl

import org.gradle.api.Plugin
import org.gradle.api.Project

class FirebaseConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            plugins.apply("com.google.gms.google-services")

            val bom = libs.firebase.bom.get()
            dependencies.apply {
                add("implementation", platform(bom))
            }
        }
    }
}