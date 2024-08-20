plugins {
    kotlin("jvm")
    `java-gradle-plugin`
}

dependencies {
    implementation(libs.android.gradlePlugin)
}

gradlePlugin {
    plugins {
        create("signing") {
            id = "convention.signing"
            implementationClass = "com.yawl.AndroidApplicationSignConventionPlugin"
        }
    }
}
