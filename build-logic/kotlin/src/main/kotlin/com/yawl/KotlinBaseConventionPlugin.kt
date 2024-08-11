package com.yawl

import org.gradle.api.Plugin
import org.gradle.api.Project
import org.jetbrains.kotlin.gradle.dsl.KotlinVersion
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

class KotlinBaseConventionPlugin : Plugin<Project> {
    override fun apply(project: Project) {
        with(project) {
            val kotlinLanguageVersion = libs.versions.kotlinLanguageVersion.get()
            tasks.withType(KotlinCompile::class.java).configureEach {
                it.compilerOptions {
                    allWarningsAsErrors.set(true)
                    languageVersion.set(KotlinVersion.fromVersion(kotlinLanguageVersion))
                    apiVersion.set(KotlinVersion.fromVersion(kotlinLanguageVersion))

                    freeCompilerArgs.set(
                        mutableListOf(
                            "-opt-in=kotlin.RequiresOptIn",
                            "-progressive"
                        )
                    )
                }
            }
        }
    }
}
