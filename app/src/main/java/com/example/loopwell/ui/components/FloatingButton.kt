package com.example.loopwell.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.outlined.DateRange
import androidx.compose.material.icons.outlined.Edit
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.loopwell.R
import com.example.loopwell.ui.screens.categories.ModalInfo
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
                Row (
                    modifier = Modifier.padding(15.dp).fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Row (
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(15.dp)
                    ) {
                        Text(
                            text = "●",
                            style = MaterialTheme.typography.headlineMedium.copy(color = Red),
                        )
                        Text(
                            text = "Create category",
                            style = MaterialTheme.typography.titleLarge.copy(color = Color.White, fontSize = 18.sp, fontWeight = FontWeight.W500)
                        )
                    }
                    Image(
                        painter = painterResource(id = R.drawable.other_icon),
                        contentDescription = "Category Icon",
                        Modifier.size(50.dp)
                    )
                }
                HorizontalDivider(thickness = 1.dp, color = BorderGray)
                ModalInfo(icon = Icons.Outlined.Edit, title = "Category name")
                ModalInfo(icon = Icons.Outlined.DateRange, title = "Category icon")
                ModalInfo(icon = Icons.Outlined.Settings, title = "Category color")
                Spacer(modifier = Modifier.height(10.dp))
                Button(
                    onClick = { },
                    shape = RoundedCornerShape(10.dp),
                    modifier = Modifier
                        .fillMaxWidth(),
                    colors = ButtonDefaults.buttonColors(contentColor = Red, containerColor = Color.Transparent),
                ) {
                    Text("CREATE CATEGORY",
                        style = MaterialTheme.typography.bodyLarge.copy(fontWeight = FontWeight.Bold, fontSize = 18.sp)
                    )
                }
            }
        }
    }
}