package com.example.compose_navigation_demo.navigation.nav_graphs

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.compose_navigation_demo.DetailsScreen
import com.example.compose_navigation_demo.HomeScreen
import com.example.compose_navigation_demo.navigation.MAIN_ROUTE
import com.example.compose_navigation_demo.navigation.ROOT_ROUTE
import com.example.compose_navigation_demo.navigation.Screen
import com.example.compose_navigation_demo.screens.StartSignUpScreen
import com.example.compose_navigation_demo.screens.StartingScreen
import com.example.compose_navigation_demo.screens.sign_up_screens.EnterNewUserStarterInfoScreen
import com.example.compose_navigation_demo.viewmodels.NewUserSignUpViewModel
import com.example.compose_navigation_demo.viewmodels.UserViewModel


@SuppressLint("RestrictedAPI")
@Composable
fun SetUpNavGraph(
    innerPadding:PaddingValues,
    navController: NavHostController,
    //Connection for User Controller View Model to share
    userViewModel: UserViewModel,
    //Connecttion for the Sign Up Screens Controller to be used in the Nav Graphs
    signUpViewModel: NewUserSignUpViewModel
    ) {
    NavHost(
        navController = navController,
        startDestination = MAIN_ROUTE,
        route = ROOT_ROUTE
    ) {

//
//        //Composable for STARTING SCREEN
//        composable(
//            route = Screen.RootStart.route
//        ) {
//            StartingScreen(navController = navController)
//        }
//
//
//
//        //composable for handling going to start sign up process
//        composable(
//            route = Screen.StartSignUpProcessScreen.route
//        ){
//            StartSignUpScreen(navController = navController)
//        }
//
//        //Composable for going to the starting Sign Up Screen
//        composable(
//            route = Screen.StartingInfoEntryScreen.route
//        ){
//            EnterNewUserStarterInfoScreen(navController = navController,signUpViewModel = signUpViewModel)
//        }
//




        //Calling the auth nav graph to activate it
        signUpNavGraph(navController = navController, signUpViewModel = signUpViewModel, userViewModel = userViewModel)

        //Calling the Root Controller Graph
        mainNavGraph(navController = navController)


    }

}


