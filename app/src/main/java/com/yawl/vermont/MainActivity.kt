package com.yawl.vermont

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.yawl.vermont.designsystem.theme.ApplicationTheme
import com.yawl.vermont.window.AppWindow

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ApplicationTheme {
                AppWindow {

                }
            }
        }
    }
}
