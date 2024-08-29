package com.yawl.sensuscommune.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.yawl.sensuscommune.designsystem.navigation.AdaptiveNavigation
import com.yawl.sensuscommune.designsystem.theme.SensusCommuneTheme

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
    SensusCommuneTheme {
        AppNavigation {

        }
    }
}