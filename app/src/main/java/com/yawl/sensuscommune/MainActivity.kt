package com.yawl.sensuscommune

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.yawl.sensuscommune.designsystem.theme.SensusCommuneTheme
import com.yawl.sensuscommune.window.AppWindow

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SensusCommuneTheme {
                AppWindow {

                }
            }
        }
    }
}
