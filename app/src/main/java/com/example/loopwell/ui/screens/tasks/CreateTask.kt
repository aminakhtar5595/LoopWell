package com.example.loopwell.ui.screens.tasks

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.loopwell.ui.theme.BackgroundColor
import com.example.loopwell.ui.theme.DarkGray
import com.example.loopwell.ui.theme.Red


@Composable
fun CreateTask(navController: NavController) {
    var taskName by remember { mutableStateOf("") }
    Box (
        modifier = Modifier
            .fillMaxSize()
            .background(color = BackgroundColor)
    ) {
        Column(
            modifier = Modifier.padding(15.dp)
        ) {
            Text(
                text = "New Task",
                style = MaterialTheme.typography.titleLarge.copy(color = Color.White),
                modifier = Modifier.background(
                    color = Color.Gray.copy(alpha = 0.1f),
                    shape = RoundedCornerShape(5.dp)
                ).padding(vertical = 8.dp, horizontal = 15.dp)
            )
            Spacer(modifier = Modifier.size(20.dp))
            OutlinedTextField(
                value = taskName,
                onValueChange = { taskName = it },
                label = { Text("Task") },
                modifier = Modifier.fillMaxWidth(),
                colors = TextFieldDefaults.colors(
                    unfocusedContainerColor = BackgroundColor,
                    unfocusedLabelColor = Red,
                    unfocusedIndicatorColor = Red,
                    focusedTextColor = Color.White,
                    focusedContainerColor = BackgroundColor,
                    focusedIndicatorColor = Red,
                    focusedLabelColor = Red
                ),
                shape = RoundedCornerShape(10.dp),
            )
            Spacer(modifier = Modifier.size(20.dp))
        }
    }
}