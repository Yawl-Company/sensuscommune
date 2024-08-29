package com.yawl.sensuscommune.designsystem.navigation

import androidx.compose.material3.adaptive.currentWindowAdaptiveInfo
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun AdaptiveNavigation(
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    val currentWindowInfo = currentWindowAdaptiveInfo()
    val layoutType = NavigationBaseComponent
        .typeByWindowInfo(currentWindowInfo)
    when (layoutType) {
        NavigationType.NavigationBar -> {

        }

        NavigationType.NavigationRoad -> {

        }
    }
}
