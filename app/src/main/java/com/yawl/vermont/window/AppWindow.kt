package com.yawl.vermont.window

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.yawl.vermont.navigation.AppNavigation

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
