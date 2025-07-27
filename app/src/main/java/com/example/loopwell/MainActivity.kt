package com.example.loopwell

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import com.example.loopwell.ui.screens.MainScreen
import com.example.loopwell.ui.theme.BackgroundColor
import com.google.accompanist.systemuicontroller.rememberSystemUiController

class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val systemUiController = rememberSystemUiController()

            systemUiController.setSystemBarsColor(
                color = BackgroundColor,
                darkIcons = false
            )
            MainScreen()
        }
    }
}