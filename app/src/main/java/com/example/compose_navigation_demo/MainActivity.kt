package com.example.compose_navigation_demo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.compose_navigation_demo.navigation.nav_graphs.SetUpNavGraph
import com.example.compose_navigation_demo.ui.theme.Compose_Navigation_DemoTheme
import com.example.compose_navigation_demo.viewmodels.NewUserSignUpViewModel
import com.example.compose_navigation_demo.viewmodels.UserViewModel

class MainActivity : ComponentActivity() {

    lateinit var navController: NavHostController


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            //Initialize a view model at the app set content level

            //make the nav controller remember itself
            //Set Up the Nav Controller from the function

            Compose_Navigation_DemoTheme {
////
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->

                navController = rememberNavController()



                val userViewModel = remember {
                    UserViewModel()
                }

                //Initialize the sign up view model
                val signUpViewModel = remember {
                    NewUserSignUpViewModel()
                }

                SetUpNavGraph(innerPadding = innerPadding,navController = navController, userViewModel = userViewModel, signUpViewModel = signUpViewModel)

//
//
//////
                }
            }
        }
    }
}
