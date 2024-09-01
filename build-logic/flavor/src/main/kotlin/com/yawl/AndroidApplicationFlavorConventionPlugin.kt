package com.yawl

import com.android.build.api.dsl.ApplicationExtension
import org.gradle.api.Plugin
import org.gradle.api.Project

class AndroidApplicationFlavorConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            extensions.configure(ApplicationExtension::class.java) { android ->
                with(android) {
                    flavorDimensions += STORE_DIMENSION
                    productFlavors {
                        create("internal") {
                            it.dimension = STORE_DIMENSION
                            it.versionCode = 1
                            it.versionName = "1.0"
                        }
                    }
                }
            }
        }
    }

    companion object {
        private const val STORE_DIMENSION = "store"
    }
}
