package com.yawl

import androidx.room.gradle.RoomExtension
import com.google.devtools.ksp.gradle.KspExtension
import org.gradle.api.Plugin
import org.gradle.api.Project

class AndroidRoomConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            plugins.apply("androidx.room")
            plugins.apply(KspConventionPlugin::class.java)

            extensions.configure(KspExtension::class.java) {
                it.arg("room.generateKotlin", "true")
            }

            extensions.configure(RoomExtension::class.java) {
                it.schemaDirectory("$projectDir/schemas")
            }

            dependencies.apply {
                add("implementation", libs.room.runtime.get())
                add("implementation", libs.room.ktx.get())
                add("ksp", libs.room.compiler.get())
            }
        }
    }
}
