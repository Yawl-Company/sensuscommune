package com.yawl.vermont.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.yawl.vermont.designsystem.navigation.AdaptiveNavigation
import com.yawl.vermont.designsystem.theme.ApplicationTheme

@Composable
fun AppNavigation(
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    AdaptiveNavigation(
        modifier = modifier
    ) {
        content()
    }
}

@Preview
@Composable
fun PreviewAppNavigation() {
    ApplicationTheme {
        AppNavigation {

        }
    }
}
