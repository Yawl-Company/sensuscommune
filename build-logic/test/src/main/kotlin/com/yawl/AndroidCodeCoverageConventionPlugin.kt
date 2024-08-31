package com.yawl

import com.android.build.api.artifact.ScopedArtifact
import com.android.build.api.dsl.CommonExtension
import com.android.build.api.variant.AndroidComponentsExtension
import com.android.build.api.variant.ScopedArtifacts
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.file.Directory
import org.gradle.api.file.RegularFile
import org.gradle.api.tasks.testing.Test
import org.gradle.internal.extensions.stdlib.capitalized
import org.gradle.testing.jacoco.plugins.JacocoPluginExtension
import org.gradle.testing.jacoco.plugins.JacocoTaskExtension
import org.gradle.testing.jacoco.tasks.JacocoReport

class AndroidCodeCoverageConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            pluginManager.apply("jacoco")

            extensions.configure(CommonExtension::class.java) { android ->
                with(android) {
                    buildTypes.configureEach {
                        it.enableUnitTestCoverage = true
                        it.enableAndroidTestCoverage = true
                    }
                }
            }

            extensions.configure(JacocoPluginExtension::class.java) {
                it.toolVersion = libs.versions.jacoco.get()
            }

            extensions.configure(AndroidComponentsExtension::class.java) { android ->
                val objects = project.objects
                val fileTree = objects.fileTree()
                val filesProperty = objects.listProperty(RegularFile::class.java)
                val directoriesProperty = objects.listProperty(Directory::class.java)

                android.onVariants { variant ->
                    val taskId = variant.name.capitalized()
                    val reportTask = tasks.register(
                        "create${taskId}CodeCoverageReport",
                        JacocoReport::class.java,
                    ) { jacoco ->
                        with(jacoco) {
                            classDirectories.setFrom(
                                filesProperty,
                                directoriesProperty.map { directories ->
                                    directories.map { directory ->
                                        fileTree
                                            .setDir(directory)
                                            .exclude(exclusions)
                                    }
                                }
                            )

                            reports.apply {
                                xml.required
                                html.required
                            }

                            sourceDirectories.setFrom(
                                files(
                                    "$projectDir/src/main/java",
                                    "$projectDir/src/main/kotlin",
                                ),
                            )

                            executionData.setFrom(
                                project.fileTree("$projectDir/out/unit_test_code_coverage/${variant.name}UnitTest")
                                    .matching { it.include("**/*.exec") },

                                project.fileTree("$projectDir/out/code_coverage/${variant.name}AndroidTest")
                                    .matching { it.include("**/*.ec") },
                            )
                        }

                        group = "Report"
                        description = "Generate code coverage report on the $taskId"
                    }

                    variant.artifacts.forScope(ScopedArtifacts.Scope.PROJECT)
                        .use(reportTask)
                        .toGet(
                            ScopedArtifact.CLASSES,
                            { _ -> filesProperty },
                            { _ -> directoriesProperty },
                        )
                }
            }

            tasks.withType(Test::class.java).configureEach { test ->
                test.extensions.configure(JacocoTaskExtension::class.java) { jacoco ->
                    with(jacoco) {
                        isIncludeNoLocationClasses = true
                        excludes = listOf("jdk.internal.*")
                    }
                }
            }
        }
    }

    private val exclusions = listOf(
        "**/R.class",
        "**/R\$*.class",
        "**/BuildConfig.*",
        "**/Manifest*.*",
        "**/*Module*.*",
        "**/*Dagger*.*",
    )
}
