package com.example.loopwell.ui.screens.habit

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.navigation.NavController
import com.example.loopwell.R

@Composable
fun HabitFlow(navController: NavController) {
    var currentPage by remember { mutableStateOf(0) }

    val onboardingItems = listOf(
        Triple(R.drawable.onboarding_icon_one, "Select a category for your habit", "This app will help you to keep an organized routine as you build new habits!"),
        Triple(R.drawable.onboarding_icon_two, "Define your habit", "To begin using LoopWell, start by recording the habits you want to track in your life along with your pending tasks.")
    )

    val isLastPage = currentPage == onboardingItems.lastIndex
    val isFirstPage = currentPage == 0

    val (image, title, desc) = onboardingItems[currentPage]

    val onSkipClick: () -> Unit = {
        if (isFirstPage) {
            navController.navigate("home") {
                popUpTo("onboarding") { inclusive = true }
            }
        } else {
            currentPage--
        }
    }

    val onNextClick: () -> Unit = {
        if (isLastPage) {
            navController.navigate("home") {
                popUpTo("onboarding") { inclusive = true }
            }
        } else {
            currentPage++
        }
    }

    val leftLabel = if (isFirstPage) "Skip" else "Back"
    val rightLabel = if (isLastPage) "Done" else "Next"

    when (currentPage) {
        0 -> SelectCategoryScreen(
            title = title,
            currentPage = currentPage,
            totalPages = onboardingItems.size,
            onSkipClick = onSkipClick,
            onNextClick = onNextClick,
            leftLabel = leftLabel,
            rightLabel = rightLabel
        )

        1 -> CreateHabitScreen(
            title = title,
            currentPage = currentPage,
            totalPages = onboardingItems.size,
            onSkipClick = onSkipClick,
            onNextClick = onNextClick,
            leftLabel = leftLabel,
            rightLabel = rightLabel
        )
    }
}