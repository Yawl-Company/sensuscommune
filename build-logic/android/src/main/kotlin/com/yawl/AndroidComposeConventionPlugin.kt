package com.yawl

import com.android.build.api.dsl.ApplicationExtension
import org.gradle.api.Plugin
import org.gradle.api.Project

class AndroidComposeConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            plugins.apply("com.android.application")
            plugins.apply("org.jetbrains.kotlin.plugin.compose")

            extensions.configure(ApplicationExtension::class.java) { base ->
                with(base) {
                    buildFeatures {
                        compose = true
                    }

                    composeOptions {
                        kotlinCompilerExtensionVersion = libs.versions.androidxComposeCompiler.get().toString()
                    }

                    val bom = libs.androidx.compose.bom.get()
                    dependencies.apply {
                        add("implementation", platform(bom))
                        add("androidTestImplementation", platform(bom))
                        add("implementation", libs.androidx.ui.tooling.preview.get())
                        add("debugImplementation", libs.androidx.ui.tooling.preview.get())
                    }
                }
            }
        }
    }
}
