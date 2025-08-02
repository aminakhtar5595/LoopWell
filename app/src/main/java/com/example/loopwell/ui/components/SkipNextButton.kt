package com.example.loopwell.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun SkipNextButton(
    leftLabel: String,
    rightLabel: String,
    currentPage: Int,
    totalPages: Int,
    onSkipClick: () -> Unit,
    onNextClick: () -> Unit
) {
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
