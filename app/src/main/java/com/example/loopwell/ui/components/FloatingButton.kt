package com.example.loopwell.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.outlined.DateRange
import androidx.compose.material.icons.outlined.Edit
import androidx.compose.material.icons.outlined.KeyboardArrowRight
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.SheetState
import androidx.compose.material3.SmallFloatingActionButton
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.loopwell.ui.theme.BackgroundColor
import com.example.loopwell.ui.theme.BorderGray
import com.example.loopwell.ui.theme.Red
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FloatingButton(onClick: () -> Unit) {
    val sheetState = rememberModalBottomSheetState(skipPartiallyExpanded = true)
    val scope = rememberCoroutineScope()
    var showSheet by remember { mutableStateOf(false) }

    SmallFloatingActionButton(
        onClick = {
            showSheet = true
            scope.launch { sheetState.show() }
        },
        containerColor = Red,
        contentColor = Color.White,
        modifier = Modifier.size(50.dp)
    ) {
        Icon(Icons.Filled.Add, "Add habit", modifier = Modifier.size(25.dp))
    }

    BottomSheetExample(showSheet = showSheet,
        sheetState = sheetState,
        onDismissRequest = { showSheet = false })
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomSheetExample(
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
                ModalInfo(icon = Icons.Outlined.Edit, title = "Habit", description = "Activity that repeats over time. It has detailed tracking and statistics.")
                ModalInfo(icon = Icons.Outlined.DateRange, title = "Recurring task", description = "Activity that repeats over time without tracking or statistics.")
                ModalInfo(icon = Icons.Outlined.Settings, title = "Task", description = "Single instance activity without tracking over time.")
            }
        }
    }
}

@Composable
fun ModalInfo(icon: ImageVector, title: String, description: String) {
    Column(modifier = Modifier.fillMaxWidth()) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp)
        ) {
            Icon(
                imageVector = icon,
                contentDescription = title,
                modifier = Modifier.size(27.dp),
                tint = Red
            )
            Spacer(modifier = Modifier.width(15.dp))

            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = title,
                    style = MaterialTheme.typography.titleLarge.copy(
                        color = Color.White,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.W500
                    )
                )
                Text(
                    text = description,
                    style = MaterialTheme.typography.bodyLarge.copy(
                        color = Color.LightGray
                    )
                )
            }

            Icon(
                imageVector = Icons.Outlined.KeyboardArrowRight,
                contentDescription = title,
                modifier = Modifier.size(25.dp),
                tint = Color.Gray
            )
        }
        HorizontalDivider(thickness = 1.dp, color = BorderGray)
    }
}
