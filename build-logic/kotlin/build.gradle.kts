plugins {
    kotlin("jvm")
    `java-gradle-plugin`
}

dependencies {
    implementation(project(":gradle-extension"))
    implementation(libs.kotlin.gradlePlugin)
    implementation(libs.ksp.gradlePlugin)
    // workaround for https://github.com/gradle/gradle/issues/15383
    implementation(files((libs as Any).javaClass.superclass.protectionDomain.codeSource.location))
}

gradlePlugin {
    plugins {
        create("ksp") {
            id = "convention.ksp"
            implementationClass = "com.yawl.KspConventionPlugin"
        }

        create("serialization") {
            id = "convention.serialization"
            implementationClass = "com.yawl.KotlinSerializationConventionPlugin"
        }
    }
}
