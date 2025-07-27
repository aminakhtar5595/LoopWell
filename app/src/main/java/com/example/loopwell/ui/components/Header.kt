package com.example.loopwell.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.DateRange
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.loopwell.R

@Composable
fun Header(title: String) {
    Row (
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 20.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row {
            Image(painter = painterResource(id = R.drawable.menu_icon),
                contentDescription = "Menu icon",
                Modifier
                    .padding(end = 20.dp)
                    .size(25.dp))

            Text(
                text = title,
                style = MaterialTheme.typography.headlineSmall.copy(color = Color.White, fontWeight = FontWeight.Bold)
            )
        }

        Row {
            Icon(
                imageVector = Icons.Outlined.Search,
                contentDescription = "Search Icon",
                modifier = Modifier.size(25.dp),
                tint = Color.Gray
            )
            Icon(
                imageVector = Icons.Outlined.DateRange,
                contentDescription = "Search Icon",
                modifier = Modifier
                    .padding(horizontal = 20.dp)
                    .size(24.dp),
                tint = Color.Gray
            )
            Image(painter = painterResource(id = R.drawable.info_icon),
                contentDescription = "Info",
                Modifier.size(24.dp))
        }

    }
}