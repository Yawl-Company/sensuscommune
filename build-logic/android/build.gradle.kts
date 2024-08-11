plugins {
    kotlin("jvm")
    `java-gradle-plugin`
}

dependencies {
    implementation(project(":kotlin"))
    implementation(project(":gradle-extension"))
    implementation(libs.android.gradlePlugin)
    // workaround for https://github.com/gradle/gradle/issues/15383
    implementation(files((libs as Any).javaClass.superclass.protectionDomain.codeSource.location))
}

gradlePlugin {
    plugins {
        create("android-lib") {
            id = "convention.kotlin-android-library"
            implementationClass = "com.yawl.AndroidLibraryConventionPlugin"
        }

        create("android-app") {
            id = "convention.kotlin-android-app"
            implementationClass = "com.yawl.AndroidApplicationConventionPlugin"
        }

        create("android-compose") {
            id = "convention.android-compose"
            implementationClass = "com.yawl.AndroidComposeConventionPlugin"
        }

        create("dagger") {
            id = "convention.dagger"
            implementationClass = "com.yawl.DaggerConventionPlugin"
        }
    }
}
