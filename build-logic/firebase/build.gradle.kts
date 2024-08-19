plugins {
    kotlin("jvm")
    `java-gradle-plugin`
}

dependencies {
    implementation(projects.gradleExtension)
    // workaround for https://github.com/gradle/gradle/issues/15383
    implementation(files((libs as Any).javaClass.superclass.protectionDomain.codeSource.location))
}

gradlePlugin {
    plugins {
        create("firebase") {
            id = "convention.firebase"
            implementationClass = "com.yawl.FirebaseConventionPlugin"
        }
    }
}
