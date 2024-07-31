package com.example.compose_navigation_demo.navigation

import kotlinx.serialization.Serializable

//The Routing String for the ROOT ROUTE
//EX: Before Choosing whether Sign up or sign in
const val ROOT_ROUTE = "root_route"

const val MAIN_ROUTE = "main_route"

//Authentication Route String for a app
//Ex: sign up, sign in, sign up portions, signing up adding info to new account details ,etc
const val SIGN_UP_ROUTE = "auth_route"

@Serializable
sealed class Screen(val route:String) {

    @Serializable
    data object RootStart: Screen(route = "root_start")

    @Serializable
    data object Detail: Screen(route = "detail_screen")


    //TODO: Screen Route object's for going to AUTH Views

    //Route for going to Start Sign Up screen
    @Serializable
    data object StartSignUpProcessScreen: Screen(route = "start_sign_up_process_screen")


    //Screen Route to go to the basic data entry screen
    @Serializable
    data object StartingInfoEntryScreen: Screen(route = "starting_info_entry_screen")


    @Serializable
    data object ReviewNewUserInfoScreen: Screen(route = "review_user_info_screen")
}