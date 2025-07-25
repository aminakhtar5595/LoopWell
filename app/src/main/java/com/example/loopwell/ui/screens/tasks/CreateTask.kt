package com.example.loopwell.ui.screens.tasks

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.DateRange
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.loopwell.R
import com.example.loopwell.ui.theme.BackgroundColor
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
                modifier = Modifier
                    .background(
                        color = Color.Gray.copy(alpha = 0.1f),
                        shape = RoundedCornerShape(5.dp)
                    )
                    .padding(vertical = 8.dp, horizontal = 15.dp)
            )
            Spacer(modifier = Modifier.size(30.dp))
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
            Spacer(modifier = Modifier.size(30.dp))

            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                TaskInfo(icon = Icons.Outlined.Info, title = "Category")
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Task",
                        style = MaterialTheme.typography.titleSmall.copy(
                            color = Red,
                        )
                    )
                    Spacer(modifier = Modifier.width(12.dp))
                    Image(painter = painterResource(id = R.drawable.task_icon),
                        contentDescription = "Category",Modifier.size(42.dp))
                }
            }
            Spacer(modifier = Modifier.size(30.dp))

            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                TaskInfo(icon = Icons.Outlined.DateRange, title = "Date")
                Text(
                    text = "Today",
                    style = MaterialTheme.typography.titleMedium.copy(color = Red),
                    modifier = Modifier
                        .background(
                            color = Red.copy(alpha = 0.1f),
                            shape = RoundedCornerShape(5.dp)
                        )
                        .padding(vertical = 10.dp, horizontal = 30.dp)
                )
            }
            Spacer(modifier = Modifier.size(30.dp))

            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                TaskInfo(icon = Icons.Outlined.Notifications, title = "Time and Reminders")
                Text(
                    text = "0",
                    style = MaterialTheme.typography.titleMedium.copy(color = Red),
                    modifier = Modifier
                        .background(
                            color = Red.copy(alpha = 0.1f),
                            shape = RoundedCornerShape(30.dp)
                        )
                        .padding(horizontal = 10.dp, vertical = 5.dp)
                )
            }
            Spacer(modifier = Modifier.size(30.dp))

            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                TaskInfo(icon = Icons.Outlined.Lock, title = "Priority")
                Text(
                    text = "Default",
                    style = MaterialTheme.typography.titleMedium.copy(color = Red),
                    modifier = Modifier
                        .background(
                            color = Red.copy(alpha = 0.1f),
                            shape = RoundedCornerShape(5.dp)
                        )
                        .padding(vertical = 10.dp, horizontal = 30.dp)
                )
            }
            Spacer(modifier = Modifier.size(30.dp))
            TaskInfo(icon = Icons.Outlined.Email, title = "Note")
        }

        Row(
            modifier = Modifier.align(Alignment.BottomCenter)
        ) {
            Button(
                onClick = { },
                colors = ButtonDefaults.buttonColors(contentColor = Color.White, containerColor = Color.Transparent),
            ) {
                Text("CANCEL",
                    style = MaterialTheme.typography.bodyLarge.copy(fontWeight = FontWeight.Bold)
                )
            }
            Spacer(modifier = Modifier.width(100.dp))
            Button(
                onClick = { },
                colors = ButtonDefaults.buttonColors(contentColor = Red, containerColor = Color.Transparent),
            ) {
                Text("CONFIRM",
                    style = MaterialTheme.typography.bodyLarge.copy(fontWeight = FontWeight.Bold)
                )
            }
        }
    }
}

@Composable
fun TaskInfo(icon: ImageVector, title: String) {
    Row {
        Icon(
            imageVector = icon,
            contentDescription = title,
            modifier = Modifier.size(27.dp),
            tint = Red
        )
        Spacer(modifier = Modifier.width(15.dp))
        Text(
            text = title,
            style = MaterialTheme.typography.titleLarge.copy(
                color = Color.White,
                fontSize = 18.sp,
                fontWeight = FontWeight.W500
            )
        )
    }
}