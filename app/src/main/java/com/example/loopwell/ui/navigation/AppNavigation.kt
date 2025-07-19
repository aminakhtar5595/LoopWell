package com.example.loopwell.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost

@Composable
fun AppNavigation(navController: NavHostController, modifier: Modifier = Modifier) {
    NavHost(navController = navController, startDestination = "splash", modifier = modifier) {
//        composable("splash") { SplashScreen() }
//        composable("home") { HomeScreen(navController) }
//        composable("search") { SearchScreen() }
//        composable("expense") { ExpenseScreen(navController) }
//        composable("category") { CategoriesScreen(navController) }
//        composable("analysis") { AnalysisScreen(navController) }
//        composable("category_details") { CategoryDetailScreen(navController) }
    }

//    LaunchedEffect(Unit) {
//        delay(2000)
//        navController.navigate("home") {
//            popUpTo("splash") { inclusive = true }
//        }
//    }
}