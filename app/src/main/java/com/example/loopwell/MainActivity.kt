package com.example.loopwell

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.ui.graphics.Color
import com.example.loopwell.ui.screens.auth.SplashScreen
import com.google.accompanist.systemuicontroller.rememberSystemUiController

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val systemUiController = rememberSystemUiController()

            // Set global status bar color here
            systemUiController.setSystemBarsColor(
                color = Color(0xFF1D1D1D),
                darkIcons = false
            )
            SplashScreen()
        }
    }
}