plugins {
    alias(libs.plugins.yawl.android.application)
    alias(libs.plugins.yawl.android.compose)
    alias(libs.plugins.yawl.dagger)
    alias(libs.plugins.yawl.firebase)
    alias(libs.plugins.yawl.android.application.flavor)
    alias(libs.plugins.yawl.android.application.sign)
    alias(libs.plugins.yawl.android.unit.test)
    alias(libs.plugins.yawl.android.ui.test)
    alias(libs.plugins.yawl.android.coverage)
}

android {
    namespace = "com.yawl.vermont"

    defaultConfig {
        applicationId = "com.yawl.vermont"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        debug {
            isMinifyEnabled = false
            applicationIdSuffix = ".debug"
        }
        release {
            isMinifyEnabled = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.compose.material3)

    implementation(projects.core.designSystem)
}
