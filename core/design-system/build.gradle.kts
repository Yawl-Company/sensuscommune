plugins {
    alias(libs.plugins.yawl.android.library)
    alias(libs.plugins.yawl.android.library.compose)
}

android {
    namespace = "com.yawl.sensuscommune.designsystem"
}

dependencies {
    api(libs.androidx.core.ktx)
    api(libs.androidx.compose.material.iconsExtended)
    api(libs.androidx.compose.material3)
    api(libs.androidx.compose.runtime)

    implementation(libs.androidx.ui.text.google.fonts)
}