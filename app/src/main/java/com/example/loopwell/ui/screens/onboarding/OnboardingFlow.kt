package com.example.loopwell.ui.screens.onboarding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.navigation.NavController
import com.example.loopwell.R
import com.example.loopwell.ui.components.OnboardingScreen

@Composable
fun OnboardingFlow(navController: NavController) {
    var currentPage by remember { mutableStateOf(0) }

    val onboardingItems = listOf(
        Triple(R.drawable.onboarding_icon_one, "Welcome to LoopWell", "This app will help you to keep an organized routine as you build new habits!"),
        Triple(R.drawable.onboarding_icon_two, "Build a Better Routine", "To begin using LoopWell, start by recording the habits you want to track in your life along with your pending tasks."),
        Triple(R.drawable.onboarding_icon_three, "Make Each Day Count", "Each day, you will receive a list of all your scheduled activities. Make sure of our customizable reminders to ensure you complete them all!"),
        Triple(R.drawable.onboarding_icon_four, "Stay Motivated", "Create streaks of success for your habits and complete all your tasks. Use the charts and tools to deeply analyze your progress."),
        Triple(R.drawable.onboarding_icon_five, "Customize Your Journey", "Try all the customization options, create a daily journal and protect your data. There are many features to discover!"),
    )

    val isLastPage = currentPage == onboardingItems.lastIndex
    val isFirstPage = currentPage == 0

    val (image, title, desc) = onboardingItems[currentPage]

    OnboardingScreen(
        imageRes = image,
        title = title,
        description = desc,
        currentPage = currentPage,
        totalPages = onboardingItems.size,

        onSkipClick = {
            if (isFirstPage) {
                navController.navigate("home") {
                    popUpTo("onboarding") { inclusive = true }
                }
            } else {
                currentPage--
            }
        },
        onNextClick = {
            if (isLastPage) {
                navController.navigate("home") {
                    popUpTo("onboarding") { inclusive = true }
                }
            } else {
                currentPage++
            }
        },

        leftLabel = if (isFirstPage) "Skip" else "Back",
        rightLabel = if (isLastPage) "Done" else "Next"
    )
}