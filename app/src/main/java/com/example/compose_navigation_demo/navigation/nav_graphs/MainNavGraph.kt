package com.example.compose_navigation_demo.navigation.nav_graphs

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.compose_navigation_demo.navigation.MAIN_ROUTE
import com.example.compose_navigation_demo.navigation.Screen
import com.example.compose_navigation_demo.screens.StartingScreen

fun NavGraphBuilder.mainNavGraph(
    navController: NavHostController
){

    navigation(
        startDestination = Screen.RootStart.route,
        route = MAIN_ROUTE
    ) {
        
        //Composable to controll a new open user going from the first starting screen to deciding 
        //between sign up (and in the future probobably sign in)
        
        //Composable to Controll Navigation To Starting Screen
        composable(
            route = Screen.RootStart.route
        ) {
            StartingScreen(navController = navController)
        }
        
    }



}