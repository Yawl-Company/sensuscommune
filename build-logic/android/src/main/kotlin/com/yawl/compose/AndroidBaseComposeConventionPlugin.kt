package com.yawl.compose

import com.android.build.api.dsl.ApplicationExtension
import com.android.build.gradle.LibraryExtension
import com.yawl.libs
import org.gradle.api.Plugin
import org.gradle.api.Project

class AndroidBaseComposeConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            plugins.apply(libs.plugins.kotlin.compose.get().pluginId)

            val extension = extensions.findByType(ApplicationExtension::class.java)
                ?: extensions.findByType(LibraryExtension::class.java)
                ?: throw IllegalStateException("Illegal caller context")

            extension.apply {
                buildFeatures {
                    compose = true
                }

                composeOptions {
                    kotlinCompilerExtensionVersion =
                        libs.versions.androidxComposeCompiler.get().toString()
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
