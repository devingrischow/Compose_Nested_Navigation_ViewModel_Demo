package com.example.compose_navigation_demo.screens.sign_up_screens

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.navigation.NavHostController
import com.example.compose_navigation_demo.viewmodels.NewUserSignUpViewModel
import com.example.compose_navigation_demo.viewmodels.UserViewModel


//TODO: Put Entry Screen Data into User Data and present onto screen
//This Screens purpose is to take user entered data from previous screens and put it on display on this screen

@Composable
fun ReviewNewUserDisplayScreen(
    signUpViewModel: NewUserSignUpViewModel,
    userViewModel: UserViewModel,
    navController: NavHostController
){

    //State value to track when the review button is pressed
    var isReviewPressed by remember { mutableStateOf<Boolean>(false) }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){

        Text(text = "Your new account is almost ready!",
            color = Color.Black,
            fontSize = MaterialTheme.typography.bodyMedium.fontSize,
            fontWeight = FontWeight.SemiBold,

        )

        Button(
            onClick = {
                Log.d("Buton", "Pressed Review Info")
                //Set internal values for user
                setNewUserDataToUser(signUpViewModel = signUpViewModel, userViewModel = userViewModel)

                //change the state of the review button to be true so the review info buttons can be checked
                isReviewPressed = true
            }
        ) {
            Text("Review your info")
            //Bottom Of Button
        }



        //3 Rows For Each Set of data

        //a row each for the data points of the user
        //row contaisn data like this:
        //Type: Value


        //Only Dipslay these additional values once the review button is pressed
        if (isReviewPressed) {


            //Name Label
            Row {
                Text(
                    text = "Name:",
                    fontSize = MaterialTheme.typography.bodyMedium.fontSize,
                    fontWeight = FontWeight.SemiBold,

                    )
                //Name Label part
                Text(
                    text = userViewModel.user.value?.name.toString(),
                    fontSize = MaterialTheme.typography.bodyMedium.fontSize,
                    fontWeight = FontWeight.SemiBold,
                )


            }

            //Age Label
            Row {
                Text(
                    text = "Age:",
                    fontSize = MaterialTheme.typography.bodyMedium.fontSize,
                    fontWeight = FontWeight.SemiBold,
                )

                //Name Label part
                Text(
                    text = userViewModel.user.value?.age.toString(),
                    fontSize = MaterialTheme.typography.bodyMedium.fontSize,
                    fontWeight = FontWeight.SemiBold,
                )

            }

            //Gender Label
            Row {
                Text(
                    text = "Gender:",
                    fontSize = MaterialTheme.typography.bodyMedium.fontSize,
                    fontWeight = FontWeight.SemiBold,

                    )

                //Name Label part
                Text(
                    text = getGenderLabel(genderVal = userViewModel.user.value?.gender),
                    fontSize = MaterialTheme.typography.bodyMedium.fontSize,
                    fontWeight = FontWeight.SemiBold,
                )


            }


        }




    }

}

fun getGenderLabel(genderVal: Int?):String {
    return if (genderVal == 1){
        "Male"
    }else{
        "Female"
    }
}


fun setNewUserDataToUser(signUpViewModel: NewUserSignUpViewModel, userViewModel: UserViewModel){


    //take the values from sign up and assign them to placeholders,
    val newName = signUpViewModel.newUserData.value?.enteringName
    val newAge = signUpViewModel.newUserData.value?.enteringAge
    val newGender = signUpViewModel.newUserData.value?.enteringGender
    Log.d("New Values To Set To User", "Name: $newName, Age: $newAge, Gender: $newGender")


    //now re assign these values back to the user view model
    if (newName != null && newAge != null && newGender != null) {
        Log.d("Did Set Values", "Passed")

        userViewModel.setInternalUserData(newName = newName, newAge = newAge, newGender = newGender)
    }else{
        Log.d("Did Set Values", "Failed")

    }


}