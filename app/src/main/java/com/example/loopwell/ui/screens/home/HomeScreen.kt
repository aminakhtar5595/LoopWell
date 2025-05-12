package com.example.loopwell.ui.screens.home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun HomeScreen() {
    Column (
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
    ) {

        Row (
            modifier = Modifier.padding(bottom = 20.dp)
        ) {
            Icon(
                imageVector = Icons.Filled.Menu,
                contentDescription = "Arrow Back",
                modifier = Modifier
                    .size(30.dp)
                    .clickable { },
            )

            Text(
                text = "HOME",
                style = MaterialTheme.typography.headlineLarge.copy(textAlign = TextAlign.Center),
                modifier = Modifier.fillMaxWidth()
            )
        }

        Text(
            text = "Habit 1",
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier.padding(bottom = 15.dp)
        )
        Divider()

        Text(
            text = "Habit 2",
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier.padding(bottom = 15.dp, top = 20.dp)
        )
        Divider()

        Text(
            text = "Habit 3",
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier.padding(bottom = 15.dp, top = 20.dp)
        )
        Divider()

        Text(
            text = "Habit 4",
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier.padding(bottom = 15.dp, top = 20.dp)
        )
        Divider()

        Text(
            text = "Habit 5",
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier.padding(bottom = 15.dp, top = 20.dp)
        )
        Divider()

        Text(
            text = "Habit 6",
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier.padding(bottom = 15.dp, top = 20.dp)
        )
        Divider()

    }
}