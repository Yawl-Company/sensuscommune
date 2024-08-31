package com.yawl.compose

import com.android.build.api.dsl.CommonExtension
import com.yawl.libs
import org.gradle.api.Plugin
import org.gradle.api.Project

class AndroidBaseComposeConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            plugins.apply(libs.plugins.kotlin.compose.get().pluginId)

            extensions.configure(CommonExtension::class.java) { android ->
                android.buildFeatures {
                    compose = true
                }

                android.composeOptions {
                    kotlinCompilerExtensionVersion =
                        libs.versions.androidxComposeCompiler.get().toString()
                }

                val bom = libs.androidx.compose.bom.get()
                dependencies.apply {
                    add("implementation", platform(bom))
                    add("androidTestImplementation", platform(bom))
                    add("implementation", libs.androidx.ui.tooling.preview.get())
                    add("debugImplementation", libs.androidx.ui.tooling.base.get())
                }
            }
        }
    }
}
