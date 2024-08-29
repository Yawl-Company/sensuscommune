package com.yawl.sensuscommune.window

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.yawl.sensuscommune.navigation.AppNavigation

@Composable
fun AppWindow(
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    AppNavigation(
        modifier = modifier
    ) {
        content()
    }
}