package com.example.loopwell.ui.screens.categories

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.DateRange
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material.icons.outlined.KeyboardArrowLeft
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.loopwell.ui.theme.BackgroundColor
import com.example.loopwell.ui.theme.DarkGray
import com.example.loopwell.ui.theme.Red

@Composable
fun CategoriesScreen() {
    Column (
        modifier = Modifier
            .fillMaxSize()
            .background(color = BackgroundColor)
    ) {
        Row (
            Modifier.fillMaxWidth().padding(vertical = 20.dp, horizontal = 5.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row (
                verticalAlignment = Alignment.Bottom
            ) {
                Icon(
                    imageVector = Icons.Outlined.KeyboardArrowLeft,
                    contentDescription = "Back arrow icon",
                    modifier = Modifier.size(30.dp),
                    tint = Red
                )

                Text(
                    text = "Categories",
                    style = MaterialTheme.typography.titleLarge.copy(
                        color = Color.White,
                        fontWeight = FontWeight.Bold
                    ), modifier = Modifier.padding(start = 10.dp)
                )
            }

            Row (
                horizontalArrangement = Arrangement.spacedBy(25.dp)
            ) {
                Icon(
                    imageVector = Icons.Outlined.DateRange,
                    contentDescription = "Date Icon",
                    modifier = Modifier.size(25.dp),
                    tint = Color.Gray
                )

                Icon(
                    imageVector = Icons.Outlined.Info,
                    contentDescription = "iNFO Icon",
                    modifier = Modifier.size(25.dp),
                    tint = Color.Gray
                )
            }
        }
        HorizontalDivider(thickness = 1.dp, color = DarkGray)
    }
}