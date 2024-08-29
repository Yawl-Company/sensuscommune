plugins {
    alias(libs.plugins.yawl.android.library)
    alias(libs.plugins.yawl.android.library.compose)
}

android {
    namespace = "com.yawl.vermont.designsystem"
}

dependencies {
    api(libs.androidx.core.ktx)
    api(libs.androidx.compose.material.iconsExtended)
    api(libs.androidx.compose.material3)
    api(libs.androidx.compose.runtime)
    api(libs.androidx.compose.material3.adaptive.layout)

    implementation(libs.androidx.ui.text.google.fonts)
}
