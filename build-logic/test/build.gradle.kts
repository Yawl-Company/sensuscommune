plugins {
    kotlin("jvm")
    `java-gradle-plugin`
}

group = "com.yawl.android.build-logic"

dependencies {
    implementation(projects.gradleExtension)
    implementation(libs.android.gradlePlugin)
    // workaround for https://github.com/gradle/gradle/issues/15383
    implementation(files((libs as Any).javaClass.superclass.protectionDomain.codeSource.location))
}

gradlePlugin {
    plugins {
        create("unit") {
            id = "convention.unit"
            implementationClass = "com.yawl.AndroidUnitTestConventionPlugin"
        }
        create("ui") {
            id = "convention.ui"
            implementationClass = "com.yawl.AndroidUiTestConventionPlugin"
        }
        create("coverage") {
            id = "convention.coverage"
            implementationClass = "com.yawl.AndroidCodeCoverageConventionPlugin"
        }
    }
}
