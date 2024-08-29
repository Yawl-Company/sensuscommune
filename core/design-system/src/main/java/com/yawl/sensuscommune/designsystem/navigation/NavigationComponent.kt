package com.yawl.sensuscommune.designsystem.navigation

import androidx.compose.material3.adaptive.WindowAdaptiveInfo
import androidx.window.core.layout.WindowHeightSizeClass
import androidx.window.core.layout.WindowWidthSizeClass

interface NavigationComponent {
    fun typeByWindowInfo(windowAdaptiveInfo: WindowAdaptiveInfo): NavigationType
}

object NavigationBaseComponent : NavigationComponent {
    override fun typeByWindowInfo(
        windowAdaptiveInfo: WindowAdaptiveInfo
    ): NavigationType {
        return with(windowAdaptiveInfo) {
            if (windowPosture.isTabletop ||
                windowSizeClass.windowHeightSizeClass == WindowHeightSizeClass.COMPACT
            ) {
                NavigationType.NavigationBar
            } else if (windowSizeClass.windowWidthSizeClass == WindowWidthSizeClass.EXPANDED ||
                windowSizeClass.windowWidthSizeClass == WindowWidthSizeClass.MEDIUM
            ) {
                NavigationType.NavigationRoad
            } else {
                NavigationType.NavigationBar
            }
        }
    }
}