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


@Composable
fun StartSignUpScreen(navController: NavController) {
    Box(modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center){


        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Text(text = "Sign Up with a new account!",
                color = Color.Cyan,
                fontSize = MaterialTheme.typography.headlineMedium.fontSize,
                fontWeight = FontWeight.Bold
            )



            Text(text = "Add Some Data to The New User!",
                color = MaterialTheme.colorScheme.secondary,
                fontSize = MaterialTheme.typography.bodyMedium.fontSize,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier
                    .padding(bottom =50.dp)
            )



            Text(text = "Next",
                color = Color.Blue,
                fontSize = MaterialTheme.typography.bodyMedium.fontSize,
                fontWeight = FontWeight.SemiBold,
                //The next button takes the viewer to the next view
                modifier = Modifier
                    .clickable {
                        Log.e("Clickable", "clicked Next button to Sign Up With New Account")



                        navController.navigate(route = Screen.StartingInfoEntryScreen.route)


                    }


            )


        }



    }
}


@Composable
@Preview
fun StartSignUpScreenPreview() {
    StartSignUpScreen(navController = rememberNavController())
}