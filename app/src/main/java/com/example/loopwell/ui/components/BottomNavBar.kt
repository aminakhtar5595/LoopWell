package com.example.loopwell.ui.components

import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.AccountBox
import androidx.compose.material.icons.outlined.DateRange
import androidx.compose.material.icons.outlined.Face
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.loopwell.ui.model.BottomNavItem
import androidx.compose.ui.unit.dp
import com.example.loopwell.ui.theme.DarkGray

@Composable
fun BottomNavBar(navController: NavController) {
    val items = listOf(
        BottomNavItem("Today", "home",Icons.Outlined.DateRange),
        BottomNavItem("Habits", "habits", Icons.Outlined.AccountBox),
        BottomNavItem("Tasks", "tasks", Icons.Outlined.Lock),
        BottomNavItem("Categories", "category", Icons.Outlined.Face)
    )

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

//    if (items.any { it.route == currentRoute }) {
        if (currentRoute != "category" && currentRoute != "create_task" && currentRoute != "habit_flow") {
        NavigationBar(
            containerColor = DarkGray
        ) {
            items.forEach { item ->
                val selected = currentRoute == item.route

                NavigationBarItem(
                    icon = {
                        Icon(
                            imageVector = item.icon,
                            contentDescription = item.label,
                            modifier = Modifier.size(30.dp),
                        )
                    },
                    label = { Text(item.label, style = MaterialTheme.typography.titleSmall.copy(color = if (selected) Color(0xFFc03755) else Color(0xFFa2a2a2))) },
                    selected = selected,
                    onClick = {
                        if (!selected) {
                            navController.navigate(item.route) {
                                popUpTo("home") { saveState = true }
                                launchSingleTop = true
                                restoreState = true
                            }
                        }
                    },
                    colors = NavigationBarItemDefaults.colors(
                        indicatorColor = Color(0xFFc03755)
                    )
                )
            }
        }
    }
}