plugins {
    alias(libs.plugins.yawl.android.library)
    alias(libs.plugins.yawl.android.library.compose)
}

android {
    namespace = "com.yawl.sensuscommune.designsystem"
}

dependencies {
    api(libs.androidx.compose.foundation.layout)
    api(libs.androidx.compose.material.iconsExtended)
    api(libs.androidx.compose.material3)
    api(libs.androidx.compose.runtime)
    api(libs.androidx.compose.ui.util)
}