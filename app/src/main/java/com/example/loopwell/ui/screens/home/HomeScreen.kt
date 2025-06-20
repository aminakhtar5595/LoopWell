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
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.loopwell.R
import java.time.LocalDate

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun HomeScreen() {
    var selectedDate by remember { mutableStateOf(LocalDate.now()) }
    var noData by remember { mutableStateOf(true) }
    val today = remember { LocalDate.now() }
    val startDate = today.minusDays(2)
    val days = (0..14).map { startDate.plusDays(it.toLong()) }

    Column (
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(0xFF121212))
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
                    contentDescription = "Add habit icon",
                    Modifier
                        .padding(end = 20.dp)
                        .size(33.dp))

                Text(
                    text = "Today",
                    style = MaterialTheme.typography.headlineSmall.copy(color = Color.White, fontWeight = FontWeight.Bold),
                )
            }

            Row {
                Image(painter = painterResource(id = R.drawable.info_icon),
                    contentDescription = "Add habit icon",
                    Modifier
                        .padding(end = 20.dp)
                        .size(30.dp))

                Image(painter = painterResource(id = R.drawable.add_icon),
                    contentDescription = "Add habit icon", Modifier.size(30.dp))
            }

        }

        HorizontalCalendar(
            days = days,
            selectedDate = selectedDate,
            onDateSelected = { selectedDate = it }
        )

        Column(
            modifier = Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center
        ) {
            if (noData) {
                NoDataView()
            }
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
                    .background(if (isSelected) Color(0xFFc03755) else Color(0xFF1c1c1c)),
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
