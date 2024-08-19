plugins {
    kotlin("jvm")
    `java-gradle-plugin`
}

dependencies {
    implementation(projects.kotlin)
    implementation(projects.gradleExtension)
    implementation(libs.android.gradlePlugin)
    implementation(libs.ksp.gradlePlugin)
    implementation(libs.room.gradlePlugin)
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

        create("android-app-compose") {
            id = "convention.android-app-compose"
            implementationClass = "com.yawl.compose.AndroidApplicationComposeConventionPlugin"
        }

        create("android-lib-compose") {
            id = "convention.android-library-compose"
            implementationClass = "com.yawl.compose.AndroidLibraryComposeConventionPlugin"
        }

        create("dagger") {
            id = "convention.dagger"
            implementationClass = "com.yawl.DaggerConventionPlugin"
        }

        create("room") {
            id = "convention.room"
            implementationClass = "com.yawl.AndroidRoomConventionPlugin"
        }
    }
}
