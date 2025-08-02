package com.example.loopwell.ui.screens.habit

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.loopwell.R
import com.example.loopwell.ui.components.PageIndicator

@Composable
fun HabitFlowScreen(
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
    val categories = listOf(
        "Quit a bad habit" to R.drawable.bad_habit_icon,
        "Arts" to R.drawable.art_icon,
        "Meditation" to R.drawable.meditation_icon,
        "Study" to R.drawable.study_icon,
        "Sports" to R.drawable.sports_icon,
        "Entertainment" to R.drawable.entertainment_icon,
        "Social" to R.drawable.social_icon,
        "Finance" to R.drawable.finance_icon,
        "Health" to R.drawable.health_icon,
        "Work" to R.drawable.work_icon,
        "Nutrition" to R.drawable.nutrition_icon,
        "Home" to R.drawable.home_icon,
        "Tasks" to R.drawable.task_icon,
        "Outdoor" to R.drawable.outdoor_icon,
        "Other" to R.drawable.other_icon,
    )
    var habitName by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(0xFF121212))
            .padding(horizontal = 10.dp),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
//        Habits list
        Column(
            modifier = Modifier.padding(top = 30.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = title,
                style = MaterialTheme.typography.headlineSmall.copy(
                    color = Color(0xFFa21752),
                    fontWeight = FontWeight.Bold,
                )
            )
            Spacer(modifier = Modifier.height(30.dp))

            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(10.dp),
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                items(categories.size) { index ->
                    val category = categories[index]
                    CategoryInfo(
                        title = category.first,
                        icon = category.second,
                    )
                }
            }
        }

//      Create habit
//        Column(
//            modifier = Modifier.padding(top = 30.dp),
//            horizontalAlignment = Alignment.CenterHorizontally
//        ) {
//            Text(
//                text = title,
//                style = MaterialTheme.typography.headlineSmall.copy(
//                    color = Color(0xFFa21752),
//                    fontWeight = FontWeight.Bold,
//                )
//            )
//            Spacer(modifier = Modifier.height(30.dp))
//            OutlinedTextField(
//                value = habitName,
//                onValueChange = { habitName = it },
//                label = { Text("Habit") },
//                modifier = Modifier.fillMaxWidth(),
//                colors = TextFieldDefaults.colors(
//                    unfocusedContainerColor = BackgroundColor,
//                    unfocusedLabelColor = Red,
//                    unfocusedIndicatorColor = Red,
//                    focusedTextColor = Color.White,
//                    focusedContainerColor = BackgroundColor,
//                    focusedIndicatorColor = Red,
//                    focusedLabelColor = Red
//                ),
//                shape = RoundedCornerShape(10.dp),
//            )
//            Spacer(modifier = Modifier.size(20.dp))
//            Text(
//                text = "e.g.. Study for the exam.",
//                style = MaterialTheme.typography.titleMedium.copy(
//                    color = Color.Gray
//                )
//            )
//            Spacer(modifier = Modifier.size(20.dp))
//            OutlinedTextField(
//                value = habitName,
//                onValueChange = { habitName = it },
//                label = { Text("Description (optional)") },
//                modifier = Modifier.fillMaxWidth(),
//                colors = TextFieldDefaults.colors(
//                    unfocusedContainerColor = BackgroundColor,
//                    unfocusedLabelColor = Red,
//                    unfocusedIndicatorColor = Red,
//                    focusedTextColor = Color.White,
//                    focusedContainerColor = BackgroundColor,
//                    focusedIndicatorColor = Red,
//                    focusedLabelColor = Red
//                ),
//                shape = RoundedCornerShape(10.dp),
//            )
//        }


        // Back and Next section
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

@Composable
fun CategoryInfo(title: String, icon: Int, modifier: Modifier = Modifier) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .background(
                color = Color.Gray.copy(alpha = 0.1f),
                shape = RoundedCornerShape(5.dp)
            )
            .padding(horizontal = 10.dp, vertical = 5.dp)
    ) {
        Text(
            text = title,
            style = MaterialTheme.typography.titleMedium.copy(
                color = Color.White
            ),
            modifier = Modifier.weight(1f) // Ensures text takes up remaining space
        )
        Image(
            painter = painterResource(id = icon),
            contentDescription = "Art icon",
            modifier = Modifier.size(40.dp)
        )
    }
}