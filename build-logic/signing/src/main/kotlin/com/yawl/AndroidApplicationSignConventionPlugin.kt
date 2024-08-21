package com.yawl

import com.android.build.api.dsl.ApplicationExtension
import org.gradle.api.Plugin
import org.gradle.api.Project
import java.io.FileInputStream
import java.util.Properties

class AndroidApplicationSignConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            val signingPropertiesFile = rootProject.file("signing.properties")
            if (signingPropertiesFile.exists()) {
                val signingProperties = Properties().apply {
                    load(FileInputStream(signingPropertiesFile))
                }
                extensions.configure(ApplicationExtension::class.java) {
                    with(it) {
                        signingConfigs.create("release").apply {
                            storeFile = file(signingProperties["keystore.path"] as String)
                            storePassword = signingProperties["keystore.password"] as String
                            keyAlias = signingProperties["key.alias"] as String
                            keyPassword = signingProperties["key.password"] as String
                        }
                        buildTypes {
                            release {
                                signingConfig = signingConfigs.findByName("release")
                            }
                        }
                    }
                }
            }
        }
    }
}
