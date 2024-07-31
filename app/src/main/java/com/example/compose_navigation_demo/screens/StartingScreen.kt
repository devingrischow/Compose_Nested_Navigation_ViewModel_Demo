package com.example.compose_navigation_demo.screens

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.compose_navigation_demo.navigation.SIGN_UP_ROUTE
import com.example.compose_navigation_demo.navigation.Screen


//This screen is for The User Choosing How To Start, and to decide to sign up
@Composable
fun StartingScreen(navController: NavController) {
    Box(modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center){


        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Text(text = "Welcome!",
                color = Color.Blue,
                fontSize = MaterialTheme.typography.headlineMedium.fontSize,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .padding(bottom = 20.dp) //Add a Spacing of 20 Underneath The Welcome Sign
            )


            Text(text = "Sign Up",
                color = Color.Gray,
                fontSize = MaterialTheme.typography.bodyMedium.fontSize,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier
                    .clickable {
                        Log.e("Thing", "Bing")
                        navController.navigate(route = SIGN_UP_ROUTE)
                    }

            )







        }







    }
}


@Composable
@Preview
fun StartingScreenPreview() {
    StartingScreen(navController = rememberNavController())
}