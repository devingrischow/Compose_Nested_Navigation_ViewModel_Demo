package com.example.compose_navigation_demo.navigation.nav_graphs

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.compose_navigation_demo.navigation.SIGN_UP_ROUTE
import com.example.compose_navigation_demo.navigation.Screen
import com.example.compose_navigation_demo.screens.StartSignUpScreen
import com.example.compose_navigation_demo.screens.sign_up_screens.EnterNewUserStarterInfoScreen
import com.example.compose_navigation_demo.screens.sign_up_screens.ReviewNewUserDisplayScreen
import com.example.compose_navigation_demo.viewmodels.NewUserSignUpViewModel
import com.example.compose_navigation_demo.viewmodels.UserViewModel


fun NavGraphBuilder.signUpNavGraph(
    navController: NavHostController,
    //Include the Sign up View model in the Sign Up Graph
    signUpViewModel: NewUserSignUpViewModel,
    userViewModel: UserViewModel
) {

    navigation(
        startDestination = Screen.StartSignUpProcessScreen.route,
        route = SIGN_UP_ROUTE
    ){

        //Composable for Handling Navigating Through SIGN UP ROUTES
        
        //composable for handling going to start sign up process
        composable(
            route = Screen.StartSignUpProcessScreen.route
        ){
            StartSignUpScreen(navController = navController)
        }


        //Composable for going to the starting Sign Up Screen
        composable(
            route = Screen.StartingInfoEntryScreen.route
        ){
            EnterNewUserStarterInfoScreen(navController = navController,signUpViewModel = signUpViewModel)
        }


        //Composable for the final review data screen
        composable(
            route = Screen.ReviewNewUserInfoScreen.route
        ){
            ReviewNewUserDisplayScreen(navController = navController, signUpViewModel = signUpViewModel, userViewModel = userViewModel)
        }



    }

}