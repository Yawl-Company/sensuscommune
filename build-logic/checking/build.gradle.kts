plugins {
    kotlin("jvm")
    `java-gradle-plugin`
}

group = "com.yawl.android.build-logic"

dependencies {
    implementation(projects.gradleExtension)
    implementation(libs.detekt.gradlePlugin)
    implementation(gradleKotlinDsl())
    // workaround for https://github.com/gradle/gradle/issues/15383
    implementation(files((libs as Any).javaClass.superclass.protectionDomain.codeSource.location))
}

gradlePlugin {
    plugins {
        create("detekt") {
            id = "convention.detekt"
            implementationClass = "com.yawl.DetektPlugin"
        }

        create("detekt-root") {
            id = "convention.detekt-root"
            implementationClass = "com.yawl.DetektRootPlugin"
        }
    }
}
