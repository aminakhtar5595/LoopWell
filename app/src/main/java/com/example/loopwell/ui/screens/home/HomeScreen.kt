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
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.loopwell.R
import java.time.LocalDate

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun HomeScreen() {
    var selectedDate by remember { mutableStateOf(LocalDate.now()) }

    // Generate a week of dates centered around today
    val days = remember {
        (0..14).map { LocalDate.now().minusDays(7).plusDays(it.toLong()) }
    }

    Column (
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(0xFF121212))
            .padding(horizontal = 10.dp, vertical = 15.dp),
    ) {
        Row (
            modifier = Modifier.fillMaxWidth()
                .padding(bottom = 20.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column {
                Text(
                    text = "Today",
                    style = MaterialTheme.typography.headlineSmall.copy(color = Color.White, fontWeight = FontWeight.Bold),
                )
            }

            Image(painter = painterResource(id = R.drawable.add_icon),
                contentDescription = "Onboarding Icon", Modifier.size(35.dp))
        }

        HorizontalCalendar(
            days = days,
            selectedDate = selectedDate,
            onDateSelected = { selectedDate = it }
        )
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun HorizontalCalendar(
    days: List<LocalDate>,
    selectedDate: LocalDate,
    onDateSelected: (LocalDate) -> Unit
) {
    LazyRow(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(days) { day ->
            val isSelected = day == selectedDate

            Box(
                modifier = Modifier
                    .clickable { onDateSelected(day) }
                    .padding(end = 20.dp)
            ) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(text = day.dayOfWeek.name.take(3), style = MaterialTheme.typography.bodyMedium.copy(color = Color.White), modifier = Modifier.padding(bottom = 20.dp))

                    Text(text = day.dayOfMonth.toString(),
                        style = MaterialTheme.typography.titleLarge.copy(color = Color.White, fontWeight = FontWeight.Bold),
                        modifier = Modifier
                            .clip(RoundedCornerShape(30.dp))
                            .background(if (isSelected) Color(0xFF6200EE) else Color.Transparent)
                            .padding(vertical = 5.dp, horizontal = 10.dp)
                        )
                }
            }
        }
    }
}
