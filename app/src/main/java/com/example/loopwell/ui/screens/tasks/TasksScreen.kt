package com.example.loopwell.ui.screens.tasks

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.loopwell.ui.components.Header
import com.example.loopwell.ui.theme.BackgroundColor

@Composable
fun TasksScreen() {
    Box (
        modifier = Modifier
            .fillMaxSize()
            .background(color = BackgroundColor)
    ) {

        Column (
            modifier = Modifier
                .padding(horizontal = 10.dp, vertical = 15.dp),
        ) {
            Header()
        }
    }
}