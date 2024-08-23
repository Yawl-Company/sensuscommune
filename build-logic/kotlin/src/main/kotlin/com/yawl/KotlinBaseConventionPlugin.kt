package com.yawl

import org.gradle.api.Plugin
import org.gradle.api.Project
import org.jetbrains.kotlin.gradle.dsl.KotlinVersion
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

class KotlinBaseConventionPlugin : Plugin<Project> {
    override fun apply(project: Project) {
        with(project) {
            plugins.apply("convention.detekt")

            val kotlinVersion = KotlinVersion.fromVersion(
                libs.versions.kotlinLanguageVersion.get()
            )
            tasks.withType(KotlinCompile::class.java).configureEach {
                it.compilerOptions {
                    allWarningsAsErrors.set(true)
                    languageVersion.set(kotlinVersion)
                    apiVersion.set(kotlinVersion)

                    freeCompilerArgs.set(
                        mutableListOf(
                            "-opt-in=kotlin.RequiresOptIn",
                            "-progressive",
                            // workaround for https://youtrack.jetbrains.com/issue/KT-68400/K2-w-Kapt-currently-doesnt-support-language-version-2.0.-Falling-back-to-1.9.
                            "-Xsuppress-version-warnings"
                        )
                    )
                }
            }
        }
    }
}
