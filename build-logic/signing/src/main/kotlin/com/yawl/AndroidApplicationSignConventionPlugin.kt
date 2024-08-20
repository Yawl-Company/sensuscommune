package com.yawl

import com.android.build.api.dsl.ApplicationExtension
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.get
import java.io.FileInputStream
import java.util.Properties

class AndroidApplicationSignConventionPlugin: Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            val signingPropertiesFile = rootProject.file("signing.properties")
            val signingProperties = Properties()

            signingProperties.load(FileInputStream(signingPropertiesFile))

            extensions.configure<ApplicationExtension> {
                signingConfigs {
                    create("release") {
                        storeFile = file(signingProperties["keystore.path"] as String)
                        storePassword = signingProperties["keystore.password"] as String
                        keyAlias = signingProperties["key.alias"] as String
                        keyPassword = signingProperties["key.password"] as String
                    }
                }

                buildTypes {
                    release {
                        signingConfig = signingConfigs["release"]
                    }
                }
            }
        }
    }
}