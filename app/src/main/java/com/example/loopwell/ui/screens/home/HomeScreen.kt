package com.example.loopwell.ui.screens.home
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.CheckCircle
import androidx.compose.material.icons.outlined.DateRange
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.loopwell.R
import com.example.loopwell.ui.components.FloatingButton
import com.example.loopwell.ui.model.HabitTask
import com.example.loopwell.ui.theme.BackgroundColor
import com.example.loopwell.ui.theme.DarkGray
import com.example.loopwell.ui.theme.Red
import java.time.LocalDate

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun HomeScreen(navController: NavController) {
    var selectedDate by remember { mutableStateOf(LocalDate.now()) }
    var noData by remember { mutableStateOf(false) }
    val today = remember { LocalDate.now() }
    val startDate = today.minusDays(2)
    val days = (0..14).map { startDate.plusDays(it.toLong()) }
    val taskList = listOf(
        HabitTask("Attend Wedding", "Task", R.drawable.social_icon),
        HabitTask("Buy Groceries", "Task", R.drawable.home_icon),
        HabitTask("Learn kotlin", "Habit", R.drawable.study_icon)
    )

    Box (
        modifier = Modifier
            .fillMaxSize()
            .background(color = BackgroundColor)
    ) {
    Column (
        modifier = Modifier
            .padding(horizontal = 10.dp, vertical = 15.dp),
    ) {
        Row (
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 20.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row {
                Image(painter = painterResource(id = R.drawable.menu_icon),
                    contentDescription = "Menu icon",
                    Modifier
                        .padding(end = 20.dp)
                        .size(25.dp))

                Text(
                    text = "Today",
                    style = MaterialTheme.typography.headlineSmall.copy(color = Color.White, fontWeight = FontWeight.Bold),
                )
            }

            Row {
                Icon(
                    imageVector = Icons.Outlined.Search,
                    contentDescription = "Search Icon",
                    modifier = Modifier.size(25.dp),
                    tint = Color.Gray
                )
                Icon(
                    imageVector = Icons.Outlined.DateRange,
                    contentDescription = "Search Icon",
                    modifier = Modifier
                        .padding(horizontal = 20.dp)
                        .size(24.dp),
                    tint = Color.Gray
                )
                Image(painter = painterResource(id = R.drawable.info_icon),
                    contentDescription = "Info",
                    Modifier.size(24.dp))
            }

        }

        HorizontalCalendar(
            days = days,
            selectedDate = selectedDate,
            onDateSelected = { selectedDate = it }
        )

        LazyColumn {
            items(taskList) { task ->
                HabitTaskItem(task = task)
            }
        }


        if (noData) {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                NoDataView()
            }
        }
    }
        Box(
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(20.dp)
        ) {
            FloatingButton(onClick = {
                navController.navigate("expense")
            })
        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun HorizontalCalendar(
    days: List<LocalDate>,
    selectedDate: LocalDate,
    onDateSelected: (LocalDate) -> Unit
) {
    LazyRow {
        items(days) { day ->
            val isSelected = day == selectedDate

            Box(
                modifier = Modifier
                    .clickable { onDateSelected(day) }
                    .padding(end = 8.dp)
                    .clip(RoundedCornerShape(20.dp))
                    .background(if (isSelected) Color(0xFFc03755) else DarkGray),
            ) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(text = day.dayOfWeek.name.take(3),
                        style = MaterialTheme.typography.labelMedium.copy(color = Color.White),
                        modifier = Modifier
                            .padding(vertical = 8.dp),
                    )

                    Box(
                        modifier = Modifier
                            .width(48.dp)
                            .background(if (isSelected) Color(0xFF912941) else Color(0xFF242424))
                            .padding(vertical = 5.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = day.dayOfMonth.toString(),
                            style = MaterialTheme.typography.titleLarge.copy(color = Color.White)
                        )
                    }

                    if (isSelected) {
                        Box(
                            modifier = Modifier
                                .width(48.dp)
                                .height(2.dp)
                                .background(Color(0xFFc0939e))
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun NoDataView() {
    Column(
        modifier = Modifier
            .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Image(
            painter = painterResource(id = R.drawable.onboarding_icon_two),
            contentDescription = "No data image",
            modifier = Modifier.size(140.dp)
        )

        Text(
            text = "There is nothing scheduled",
            style = MaterialTheme.typography.titleLarge.copy(
                color = Color.White,
                fontWeight = FontWeight.Bold
            ),
            modifier = Modifier.padding(top = 30.dp, bottom = 10.dp)
        )

        Text(
            text = "Try adding new activities",
            style = MaterialTheme.typography.bodyLarge.copy(
                color = Color(0xFFa2a2a2),
                textAlign = TextAlign.Center,
                fontSize = 18.sp
            ),
            modifier = Modifier.padding(horizontal = 20.dp)
        )
    }
}

@Composable
fun HabitTaskItem(task: HabitTask) {
    Row (
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 20.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row {
            Image(painter = painterResource(id = task.iconRes),
                contentDescription = "Social Icon",
                Modifier.size(45.dp))

            Column (
                modifier = Modifier.padding(start = 15.dp)
            ) {
                Text(
                    text = task.name,
                    style = MaterialTheme.typography.titleMedium.copy(
                        color = Color.White,
                        fontSize = 18.sp
                    )
                )

                Text(
                    text = task.type,
                    style = MaterialTheme.typography.titleSmall.copy(
                        color = Red
                    ), modifier = Modifier
                        .background(
                            color = Color.Red.copy(alpha = 0.2f),
                            shape = RoundedCornerShape(5.dp)
                        )
                        .padding(3.dp)
                )
            }
        }

        Icon(
            imageVector = Icons.Outlined.CheckCircle,
            contentDescription = "Search Icon",
            modifier = Modifier.size(30.dp),
            tint = Color.Gray
        )
    }
    HorizontalDivider(thickness = 1.dp, color = DarkGray)
}