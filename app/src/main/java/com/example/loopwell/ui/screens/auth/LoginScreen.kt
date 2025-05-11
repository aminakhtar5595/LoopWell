package com.example.loopwell.ui.screens.auth

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen() {
    var emailText by remember { mutableStateOf("") }
    var passwordText by remember { mutableStateOf("") }

    Column (
        modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth()
            .padding(20.dp),
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "LOGIN",
            style = TextStyle(
                textAlign = TextAlign.Center,
                fontSize = 40.sp,
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 20.dp)
        )

        Text(
            text = "Email",
            style = TextStyle(
                textAlign = TextAlign.Center,
                fontSize = 20.sp,
            ),
            modifier = Modifier.padding(bottom = 5.dp)
        )

        TextField(
            textStyle = TextStyle(
                fontSize = 16.sp,
            ),
            value = emailText,
            onValueChange = {
            },
//            colors = TextFieldDefaults.textFieldColors(
//                containerColor = Color.Transparent,
//                textColor = Color.Gray,
//                focusedIndicatorColor = Color.Transparent,
//                unfocusedIndicatorColor = Color.Transparent,
//                placeholderColor = Color.Gray
//            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 15.dp)
                .border(width = 1.5.dp, color = Color(0xFFE5E8EB)),
            shape = RoundedCornerShape(10.dp),
            placeholder = { Text("Enter your email") },
        )

        Text(
            text = "Password",
            style = TextStyle(
                textAlign = TextAlign.Center,
                fontSize = 20.sp,
            ),
            modifier = Modifier.padding(bottom = 5.dp)
        )

        TextField(
            textStyle = TextStyle(
                fontSize = 16.sp,
            ),
            value = passwordText,
            onValueChange = {
            },
//            colors = TextFieldDefaults.textFieldColors(
//                containerColor = Color.Transparent,
//                textColor = Color.Gray,
//                focusedIndicatorColor = Color.Transparent,
//                unfocusedIndicatorColor = Color.Transparent,
//                placeholderColor = Color.Gray
//            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 30.dp)
                .border(width = 1.5.dp, color = Color(0xFFE5E8EB)),
            shape = RoundedCornerShape(10.dp),
            placeholder = { Text("Enter your password") },
        )

        Button(
            onClick = {  },
            shape = RoundedCornerShape(10.dp),
            contentPadding = PaddingValues(vertical = 15.dp),
            border = BorderStroke(1.5.dp, Color(0xFF4F7CCB)),
            colors = ButtonDefaults.buttonColors(
                contentColor = Color(0xFF4F7CCB),
                containerColor = Color.Transparent
            ),
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = "LOG IN",
                style = TextStyle(
                    fontSize = 18.sp,
                    fontWeight = FontWeight.W500
                )
            )
        }

        Text(
            text = "Forgot Password?",
            style = TextStyle(
                textAlign = TextAlign.Center,
                fontSize = 20.sp,
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 20.dp)
        )
    }
}