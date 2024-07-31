package com.example.compose_navigation_demo

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.compose_navigation_demo.navigation.Screen


@Composable
fun HomeScreen(navController: NavController) {
    Box(modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center){


        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Text(text = "Home",
                color = MaterialTheme.colorScheme.primary,
                fontSize = MaterialTheme.typography.headlineMedium.fontSize,
                fontWeight = FontWeight.Bold
            )



            Text(text = "Go To Details Screen",
                color = MaterialTheme.colorScheme.secondary,
                fontSize = MaterialTheme.typography.bodySmall.fontSize,
                //Clickable Context
                modifier = Modifier.clickable {
                    navController.navigate(Screen.Detail.route)
                }
            )

        }



    }
}


@Composable
@Preview
fun HomeScreenPreview() {
    HomeScreen(navController = rememberNavController())
}