package com.example.loopwell.ui.screens.habit

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun AddHabitScreen() {
    Column (
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
    ) {
        Row (
            modifier = Modifier.padding(bottom = 20.dp)
        ) {
            Icon(
                imageVector = Icons.Filled.ArrowBack,
                contentDescription = "Arrow Back",
                modifier = Modifier
                    .size(30.dp)
                    .clickable { },
            )

            Text(
                text = "ADD HABIT",
                style = MaterialTheme.typography.headlineLarge.copy(textAlign = TextAlign.Center),
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}