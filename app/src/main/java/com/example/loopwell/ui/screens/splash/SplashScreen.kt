package com.example.loopwell.ui.screens.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import com.example.loopwell.R
import com.example.loopwell.ui.theme.BackgroundDarkColor

@Composable
fun SplashScreen() {
    Column (
        modifier = Modifier.fillMaxSize().background(color = BackgroundDarkColor),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Image(painter = painterResource(id = R.drawable.splash_icon),
            contentDescription = "Splash Icon")
    }
}