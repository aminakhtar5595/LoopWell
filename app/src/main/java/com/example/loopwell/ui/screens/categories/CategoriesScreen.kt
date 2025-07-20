package com.example.loopwell.ui.screens.categories

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.KeyboardArrowLeft
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.loopwell.ui.theme.BackgroundColor
import com.example.loopwell.ui.theme.Red

@Composable
fun CategoriesScreen() {
    Column (
        modifier = Modifier.fillMaxSize().background(color = BackgroundColor).padding(vertical = 15.dp, horizontal = 10.dp)
    ) {
        Row {
            Icon(
                imageVector = Icons.Outlined.KeyboardArrowLeft,
                contentDescription = "Search Icon",
                modifier = Modifier.size(30.dp),
                tint = Red
            )
        }
    }
}