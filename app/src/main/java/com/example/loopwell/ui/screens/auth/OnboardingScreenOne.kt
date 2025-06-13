package com.example.loopwell.ui.screens.auth
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.loopwell.R

@Composable
fun OnboardingScreenOne() {
    Column (
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(0xFF121212))
            .padding(horizontal = 10.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Image(painter = painterResource(id = R.drawable.onboarding_icon_one),
            contentDescription = "Onboarding Icon", Modifier.size(220.dp))

        Text(
            text = "Welcome to LoopWell",
            style = MaterialTheme.typography.headlineSmall.copy(color = Color(0xFFa21752), fontWeight = FontWeight.Bold),
            modifier = Modifier.padding(top = 30.dp, bottom = 10.dp)
        )

        Text(
            text = "This app will help you to keep an organized routine as you build new habits!",
            style = MaterialTheme.typography.bodyLarge.copy(color = Color.White, textAlign = TextAlign.Center, fontSize = 18.sp),
        )
    }

    Row (
        modifier = Modifier
            .padding(horizontal = 60.dp, vertical = 10.dp)
            .fillMaxSize(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.Bottom
    ) {
        Text(
            text = "Skip",
            style = MaterialTheme.typography.bodyMedium.copy(color = Color.White),
        )

        Text(
            text = "oooo",
            style = MaterialTheme.typography.bodyMedium.copy(color = Color.White),
        )

        Text(
            text = "Next",
            style = MaterialTheme.typography.bodyMedium.copy(color = Color.White),
        )
    }
}
