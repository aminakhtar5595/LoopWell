package com.example.loopwell

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.loopwell.ui.screens.auth.LoginScreen
import com.example.loopwell.ui.screens.auth.SignupScreen
import com.example.loopwell.ui.screens.auth.SplashScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SignupScreen()
        }
    }
}