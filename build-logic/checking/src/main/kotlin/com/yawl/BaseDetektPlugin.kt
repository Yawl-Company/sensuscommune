package com.yawl

import io.gitlab.arturbosch.detekt.Detekt
import org.gradle.api.Plugin
import org.gradle.api.Project

class BaseDetektPlugin : Plugin<Project> {
    override fun apply(project: Project) {
        with(project) {
            plugins.apply("base")
            plugins.apply("io.gitlab.arturbosch.detekt")
            project.dependencies.add("detektPlugins", libs.detektFormatting)

            val detektTask = tasks.named("detekt", Detekt::class.java)
            detektTask.configure { task ->
                task.apply {
                    parallel = true

                    config.setFrom(files(project.rootDir.resolve("conf/detekt.yml")))
                    buildUponDefaultConfig = false

                    include("**/*.kt")
                    include("**/*.kts")
                    reports { report ->
                        report.xml.required.set(false)
                        report.html.required.set(false)
                    }
                }
            }

            tasks.named("check").configure { check ->
                check.dependsOn(detektTask)
            }
        }
    }
}
