package com.example.loopwell.ui.screens.habit

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun AddHabitScreen() {
    var titleText by remember { mutableStateOf("") }
    var frequencyText by remember { mutableStateOf("") }

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

        Text(
            text = "Habit Title",
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier.padding(bottom = 5.dp)
        )

        TextField(
            textStyle = TextStyle(
                fontSize = 16.sp,
            ),
            value = titleText,
            onValueChange = {
                titleText = it
            },
            colors = TextFieldDefaults.colors(
                unfocusedContainerColor = Color.Transparent,
                focusedContainerColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                focusedIndicatorColor = Color.Transparent,
                cursorColor = Color.Black
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 15.dp)
                .border(width = 1.5.dp, color = Color(0xFFE5E8EB)),
            shape = RoundedCornerShape(10.dp),
            placeholder = { Text("Enter your habit title") },
        )

        Text(
            text = "Frequency",
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier.padding(bottom = 5.dp)
        )

        TextField(
            textStyle = TextStyle(
                fontSize = 16.sp,
            ),
            value = frequencyText,
            onValueChange = {
                frequencyText = it
            },
            colors = TextFieldDefaults.colors(
                unfocusedContainerColor = Color.Transparent,
                focusedContainerColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                focusedIndicatorColor = Color.Transparent,
                cursorColor = Color.Black
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 15.dp)
                .border(width = 1.5.dp, color = Color(0xFFE5E8EB)),
            shape = RoundedCornerShape(10.dp),
            placeholder = { Text("Enter your frequency") },
        )
    }
}