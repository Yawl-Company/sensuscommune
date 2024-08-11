plugins {
    kotlin("jvm")
}

dependencies {
    compileOnly(gradleApi())
    // workaround for https://github.com/gradle/gradle/issues/15383
    implementation(files(libs.javaClass.superclass.protectionDomain.codeSource.location))
}
