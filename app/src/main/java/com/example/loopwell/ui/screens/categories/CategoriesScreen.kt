package com.example.loopwell.ui.screens.categories

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.DateRange
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material.icons.outlined.KeyboardArrowLeft
import androidx.compose.material.icons.outlined.Refresh
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.HorizontalDivider
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
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.loopwell.R
import com.example.loopwell.ui.model.Category
import com.example.loopwell.ui.theme.BackgroundColor
import com.example.loopwell.ui.theme.DarkGray
import com.example.loopwell.ui.theme.Red

@Composable
fun CategoriesScreen(navController: NavController) {
    val categories = listOf(
        Category("Study", R.drawable.study_icon, "2 entries"),
        Category("Sports", R.drawable.sports_icon, "0 entries"),
        Category("Entertainment", R.drawable.entertainment_icon, "0 entries"),
        Category("Social", R.drawable.social_icon, "1 entry"),
        Category("Finance", R.drawable.finance_icon, "0 entries"),
        Category("Health", R.drawable.health_icon, "0 entries"),
        Category("Work", R.drawable.work_icon, "0 entries"),
        Category("Nutrition", R.drawable.nutrition_icon, "0 entries"),
        Category("Home", R.drawable.home_icon, "0 entries"),
        Category("Quit a bad habit", R.drawable.bad_habit_icon, "0 entries"),
        Category("Art", R.drawable.art_icon, "0 entries"),
        Category("Tasks", R.drawable.task_icon, "0 entries"),
        Category("Meditation", R.drawable.meditation_icon, "0 entries"),
        Category("Outdoor", R.drawable.outdoor_icon, "0 entries"),
        Category("Other", R.drawable.other_icon, "0 entries")
    )

    Box (
        modifier = Modifier
            .fillMaxSize()
            .background(color = BackgroundColor)
    )  {
        Column (
            modifier = Modifier
                .fillMaxSize()
        ) {
            HeaderView(navController)
            HorizontalDivider(thickness = 1.dp, color = DarkGray)

            Column (
                Modifier.padding(20.dp),
            ) {
                CategoryHeader(title = "Custom Categories", description = "5 available")
                Spacer(modifier = Modifier.height(20.dp))

                Column (
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Icon(
                        imageVector = Icons.Outlined.Refresh,
                        contentDescription = "No category icon",
                        modifier = Modifier.size(30.dp),
                        tint = Color.Gray
                    )
                    Text(
                        text = "There are no custom categories",
                        style = MaterialTheme.typography.bodyLarge.copy(
                            color = Color.Gray
                        ), modifier = Modifier.padding(top = 10.dp, bottom = 30.dp)
                    )
                }

            }
            HorizontalDivider(thickness = 1.dp, color = DarkGray)
            Column (
                Modifier.padding(20.dp),
            ) {
                CategoryHeader(title = "Default categories", description = "Editable for premium users")
                Spacer(modifier = Modifier.height(20.dp))

                LazyRow(horizontalArrangement = Arrangement.spacedBy(20.dp)) {
                    items(categories) { category ->
                        CategoryItem(category)
                    }
                }
            }
            HorizontalDivider(thickness = 1.dp, color = DarkGray)
        }
        Button(
            onClick = {  },
            shape = RoundedCornerShape(10.dp),
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter)
                .padding(20.dp),
            contentPadding = PaddingValues(vertical = 18.dp),
            colors = ButtonDefaults.buttonColors(contentColor = Color.Black, containerColor = Red),
        ) {
            Text("NEW CATEGORY",
                style = MaterialTheme.typography.bodyLarge.copy(fontWeight = FontWeight.Bold, fontSize = 18.sp)
            )
        }
    }

}

@Composable
fun HeaderView (navController: NavController) {
    Row (
        Modifier
            .fillMaxWidth()
            .padding(vertical = 20.dp, horizontal = 5.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Row (
            verticalAlignment = Alignment.Bottom
        ) {
            Icon(
                imageVector = Icons.Outlined.KeyboardArrowLeft,
                contentDescription = "Back arrow icon",
                modifier = Modifier.size(30.dp).clickable { navController.popBackStack() },
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
}

@Composable
fun CategoryItem(category: Category) {
    val truncatedName = if (category.name.length > 8) {
        category.name.take(8) + "..."
    } else {
        category.name
    }
    Column (
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = category.iconRes),
            contentDescription = "${category.name} Icon",
            Modifier.size(75.dp)
        )
        Text(
            text = truncatedName,
            style = MaterialTheme.typography.bodyLarge.copy(color = Color.White, fontWeight = FontWeight.W500)
        )
        Text(
            text = category.entries,
            style = MaterialTheme.typography.bodyMedium.copy(color = Color.Gray, fontWeight = FontWeight.W500)
        )
    }
}

@Composable
fun CategoryHeader(title: String, description: String) {
    Text(
        text = title,
        style = MaterialTheme.typography.bodyLarge.copy(color = Color.White)
    )

    Text(
        text = description,
        style = MaterialTheme.typography.bodyMedium.copy(color = Color.Gray)
    )
}