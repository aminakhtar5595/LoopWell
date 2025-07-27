package com.example.loopwell.ui.navigation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.loopwell.ui.screens.categories.CategoriesScreen
import com.example.loopwell.ui.screens.habit.HabitsScreen
import com.example.loopwell.ui.screens.splash.SplashScreen
import com.example.loopwell.ui.screens.home.HomeScreen
import com.example.loopwell.ui.screens.onboarding.OnboardingFlow
import com.example.loopwell.ui.screens.tasks.CreateTask
import com.example.loopwell.ui.screens.tasks.TasksScreen
import kotlinx.coroutines.delay

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun AppNavigation(navController: NavHostController, modifier: Modifier = Modifier) {
    NavHost(navController = navController, startDestination = "create_task", modifier = modifier) {
        composable("splash") { SplashScreen() }
        composable("home") { HomeScreen(navController) }
        composable("onboarding") { OnboardingFlow(navController) }
        composable("habits") { HabitsScreen() }
        composable("category") { CategoriesScreen(navController) }
        composable("tasks") { TasksScreen(navController) }
        composable("create_task") { CreateTask(navController) }
    }

    LaunchedEffect(Unit) {
        delay(2000)
        navController.navigate("create_task") {
            popUpTo("splash") { inclusive = true }
        }
    }
}