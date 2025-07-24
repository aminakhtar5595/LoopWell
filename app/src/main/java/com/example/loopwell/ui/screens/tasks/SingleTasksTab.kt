package com.example.loopwell.ui.screens.tasks

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import com.example.loopwell.R
import com.example.loopwell.ui.components.TaskItem
import com.example.loopwell.ui.model.HabitTask

@Composable
fun SingleTasksTab() {
    val taskList = listOf(
        HabitTask("Research on masters program", "Everyday", R.drawable.study_icon),
    )

    LazyColumn {
        items(taskList) { task ->
            TaskItem(task = task)
        }
    }
}