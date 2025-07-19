package com.example.loopwell.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
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

@Composable
fun OnboardingScreen(
    imageRes: Int,
    title: String,
    description: String,
    currentPage: Int,
    totalPages: Int,
    onNextClick: () -> Unit,
    onSkipClick: () -> Unit,
    leftLabel: String,
    rightLabel: String
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(0xFF121212))
            .padding(horizontal = 10.dp),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(top = 60.dp)
        ) {
            Image(
                painter = painterResource(id = imageRes),
                contentDescription = "Onboarding Image",
                modifier = Modifier.size(220.dp)
            )

            Text(
                text = title,
                style = MaterialTheme.typography.headlineSmall.copy(
                    color = Color(0xFFa21752),
                    fontWeight = FontWeight.Bold
                ),
                modifier = Modifier.padding(top = 30.dp, bottom = 10.dp)
            )

            Text(
                text = description,
                style = MaterialTheme.typography.bodyLarge.copy(
                    color = Color.White,
                    textAlign = TextAlign.Center,
                    fontSize = 18.sp
                ),
                modifier = Modifier.padding(horizontal = 20.dp)
            )
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 40.dp, vertical = 20.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = leftLabel,
                style = MaterialTheme.typography.bodyMedium.copy(color = Color.White),
                modifier = Modifier.clickable { onSkipClick() }
            )
            PageIndicator(currentPage = currentPage, totalPages = totalPages)

            Text(
                text = rightLabel,
                style = MaterialTheme.typography.bodyMedium.copy(color = Color.White),
                modifier = Modifier.clickable { onNextClick() }
            )
        }
    }
}