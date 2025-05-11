package com.example.loopwell.ui.screens.auth

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun SignupScreen() {
    Column (
        modifier = Modifier
//            .fillMaxHeight()
//            .fillMaxWidth()
            .padding(20.dp),
//        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "SIGNUP",
            style = TextStyle(
                textAlign = TextAlign.Center,
                fontSize = 40.sp,
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 20.dp)
        )
    }
}