package com.example.loopwell.ui.components

import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Icon
import androidx.compose.material3.SmallFloatingActionButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.loopwell.ui.theme.Red

@Composable
fun FloatingButton(onClick: () -> Unit) {
    SmallFloatingActionButton(
        onClick = { onClick() },
        containerColor = Red,
        contentColor = Color.White,
        modifier = Modifier.size(50.dp)
    ) {
        Icon(Icons.Filled.Add, "Add habit", modifier = Modifier.size(25.dp))
    }
}