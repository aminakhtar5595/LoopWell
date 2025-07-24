package com.example.loopwell.ui.screens.tasks

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import com.example.loopwell.R
import com.example.loopwell.ui.components.TaskItem
import com.example.loopwell.ui.model.HabitTask

@Composable
fun RecurringTasksTab() {
    val taskList = listOf(
        HabitTask("Buy groceries", "Everyday", R.drawable.home_icon),
        HabitTask("Complete task module", "Everyday", R.drawable.outdoor_icon)
    )

    LazyColumn {
        items(taskList) { task ->
            TaskItem(task = task)
        }
    }
}
