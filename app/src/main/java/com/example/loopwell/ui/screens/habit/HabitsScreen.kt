package com.example.loopwell.ui.screens.habit

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.AccountBox
import androidx.compose.material.icons.outlined.CheckCircle
import androidx.compose.material.icons.outlined.DateRange
import androidx.compose.material.icons.outlined.Delete
import androidx.compose.material.icons.outlined.Edit
import androidx.compose.material.icons.outlined.MoreVert
import androidx.compose.material.icons.outlined.Place
import androidx.compose.material.icons.outlined.Share
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.SheetState
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
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
import com.example.loopwell.ui.components.FloatingButton
import com.example.loopwell.ui.components.Header
import com.example.loopwell.ui.theme.BackgroundColor
import com.example.loopwell.ui.theme.BorderGray
import com.example.loopwell.ui.theme.Red

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HabitsScreen(navController: NavController) {
    val sheetState = rememberModalBottomSheetState(skipPartiallyExpanded = true)
    val scope = rememberCoroutineScope()
    var showSheet by remember { mutableStateOf(false) }
    Box (
        modifier = Modifier
            .fillMaxSize()
            .background(color = BackgroundColor)
    ) {
        Column (
            modifier = Modifier
                .padding(horizontal = 10.dp, vertical = 15.dp)
        ) {
            Header(title = "Habits")
            HabitItem()
            Spacer(modifier = Modifier.height(15.dp))
            HabitItem()
        }

        Box(
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(20.dp)
        ) {
            FloatingButton(navController)
        }
    }
    HabitBottomSheet(showSheet = showSheet,
        sheetState = sheetState,
        onDismissRequest = { showSheet = false })
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HabitBottomSheet(
    showSheet: Boolean,
    sheetState: SheetState,
    onDismissRequest: () -> Unit
) {
    if (showSheet) {
        ModalBottomSheet(
            onDismissRequest = onDismissRequest,
            sheetState = sheetState,
            dragHandle = null,
            tonalElevation = 0.dp,
            scrimColor = Color.Black.copy(alpha = 0.5f),
            containerColor = BackgroundColor
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(BackgroundColor)
            ) {
                Row (
                    modifier = Modifier
                        .padding(15.dp)
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Column (
                        verticalArrangement = Arrangement.Center
                    ) {
                        Text(
                            text = "Learn Kotlin",
                            style = MaterialTheme.typography.titleLarge.copy(color = Color.White, fontSize = 18.sp, fontWeight = FontWeight.W500)
                        )
                        Text(
                            text = "Every 2 days (Flexible)",
                            style = MaterialTheme.typography.bodyMedium.copy(color = Red),
                            modifier = Modifier
                                .background(
                                    color = Red.copy(alpha = 0.1f),
                                    shape = RoundedCornerShape(5.dp)
                                )
                                .padding(horizontal = 5.dp)
                        )
                        Spacer(modifier = Modifier.height(5.dp))
                        Text(
                            text = "Jetpack compose",
                            style = MaterialTheme.typography.bodyMedium.copy(color = Color.Gray),
                            modifier = Modifier
                                .background(
                                    color = Color.Gray.copy(alpha = 0.1f),
                                    shape = RoundedCornerShape(5.dp)
                                )
                                .padding(horizontal = 5.dp)
                        )
                    }
                    Image(
                        painter = painterResource(id = R.drawable.bad_habit_icon),
                        contentDescription = "Category Icon",
                        Modifier.size(50.dp)
                    )
                }
                HorizontalDivider(thickness = 1.dp, color = BorderGray)
                ModalInfo(icon = Icons.Outlined.DateRange, title = "Calendar")
                ModalInfo(icon = Icons.Outlined.AccountBox, title = "Statistics")
                ModalInfo(icon = Icons.Outlined.Edit, title = "Edit")
                ModalInfo(icon = Icons.Outlined.Share, title = "Archive")
                ModalInfo(icon = Icons.Outlined.Delete, title = "Delete")
            }
        }
    }
}

@Composable
fun ModalInfo(icon: ImageVector, title: String) {
    Row (
        horizontalArrangement = Arrangement.spacedBy(18.dp),
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.padding(20.dp)
    ) {
        Icon(
            imageVector = icon,
            contentDescription = title,
            modifier = Modifier.size(27.dp),
            tint = Color.Gray
        )
        Text(
            text = title,
            style = MaterialTheme.typography.titleLarge.copy(color = Color.White, fontSize = 18.sp)
        )
    }
    HorizontalDivider(thickness = 1.dp, color = BorderGray)
}

@Composable
fun HabitItem() {
    Column(
        modifier = Modifier
            .background(
                color = Color.DarkGray.copy(alpha = 0.1f),
                shape = RoundedCornerShape(20.dp)
            )
            .padding(vertical = 15.dp)
    ) {
        Row (
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 10.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Column (
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "Learn Kotlin",
                    style = MaterialTheme.typography.titleLarge.copy(color = Color.White, fontSize = 18.sp, fontWeight = FontWeight.W500)
                )
                Text(
                    text = "Every 2 days (Flexible)",
                    style = MaterialTheme.typography.bodyMedium.copy(color = Red),
                    modifier = Modifier
                        .background(
                            color = Red.copy(alpha = 0.1f),
                            shape = RoundedCornerShape(5.dp)
                        )
                        .padding(horizontal = 5.dp)
                )
            }
            Image(
                painter = painterResource(id = R.drawable.bad_habit_icon),
                contentDescription = "Category Icon",
                Modifier.size(40.dp)
            )
        }
        Spacer(modifier = Modifier.height(20.dp))
        HorizontalDivider(thickness = 1.dp, color = Color.Gray.copy(alpha = 0.3f))
        Spacer(modifier = Modifier.height(10.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 10.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Icon(
                    imageVector = Icons.Outlined.Share,
                    contentDescription = "Icon content",
                    modifier = Modifier.size(18.dp),
                    tint = Red
                )
                Text(
                    text = "0",
                    style = MaterialTheme.typography.bodyLarge.copy(color = Color.White),
                    modifier = Modifier.padding(start = 5.dp, end = 10.dp)
                )
                Icon(
                    imageVector = Icons.Outlined.CheckCircle,
                    contentDescription = "Icon content",
                    modifier = Modifier.size(20.dp),
                    tint = Red
                )
                Text(
                    text = "0%",
                    style = MaterialTheme.typography.bodyLarge.copy(color = Color.White),
                    modifier = Modifier.padding(start = 5.dp, end = 10.dp)
                )
            }

            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(15.dp)
            ) {
                Icon(
                    imageVector = Icons.Outlined.DateRange,
                    contentDescription = "Icon content",
                    modifier = Modifier.size(25.dp),
                    tint = Color.Gray
                )
                Icon(
                    imageVector = Icons.Outlined.Place,
                    contentDescription = "Icon content",
                    modifier = Modifier.size(25.dp),
                    tint = Color.Gray
                )
                Icon(
                    imageVector = Icons.Outlined.MoreVert,
                    contentDescription = "Icon content",
                    modifier = Modifier.size(25.dp),
                    tint = Color.Gray
                )
            }
        }
    }
}