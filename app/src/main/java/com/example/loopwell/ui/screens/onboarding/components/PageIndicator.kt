package com.example.loopwell.ui.screens.onboarding.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun PageIndicator(currentPage: Int, totalPages: Int) {
    Row(horizontalArrangement = Arrangement.Center) {
        repeat(totalPages) { index ->
            val color = if (index == currentPage) Color(0xFFa21752) else Color.Gray
            Text(
                text = "●",
                modifier = Modifier.padding(horizontal = 2.dp),
                style = MaterialTheme.typography.titleMedium.copy(color = color),
            )
        }
    }
}
