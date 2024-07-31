package com.example.compose_navigation_demo.screens.sign_up_screens

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.compose_navigation_demo.navigation.Screen
import com.example.compose_navigation_demo.screens.StartingScreen
import com.example.compose_navigation_demo.viewmodels.NewUserSignUpViewModel
import kotlin.math.sign


@Composable
fun EnterNewUserStarterInfoScreen(
    navController: NavController,
//    //Include the new Sign Up User View Model
    signUpViewModel: NewUserSignUpViewModel
) {

    var nameEntry by remember { mutableStateOf<String>("") }
    var ageEntry by remember { mutableStateOf<String>("") }

    var genderChoice by remember { mutableStateOf<Int>(1) }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){

        Text(text = "Enter some basic required starting info",
            color = Color.Black,
            fontSize = MaterialTheme.typography.titleLarge.fontSize,
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.SemiBold,

            modifier = Modifier
                .padding(bottom = 30.dp)
        )
        
        
//        //Get the users Name
        TextField(
            value = nameEntry,
            onValueChange = { nameEntry = it  },
            label = {
                Text(text = "Enter your name: ")

            },
            modifier = Modifier
                .padding(bottom = 20.dp)
        )


        TextField(
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            value = ageEntry,
            onValueChange = { ageEntry = it  },
            label = {
                Text(text = "Enter your age: ")
            },
            modifier = Modifier
                .padding(bottom = 20.dp)
        )


        Text(text = "Choose Your Gender",
            color = Color.Blue,
            fontSize = MaterialTheme.typography.bodyLarge.fontSize,
            fontWeight = FontWeight.SemiBold,
            modifier = Modifier
                .padding(bottom = 10.dp)

        )

        //2 separate Button Gender Chooser
        //This will be a simple 2 button picker where whatever button is pressed,
        // its color will change to the corresponding color
        Row(
            modifier = Modifier
                .padding(bottom = 20.dp)
        ) {

            Spacer(modifier = Modifier.padding())

            Button(

                onClick = {

                    Log.d("OUT", "OuterRide")
                    genderChoice = 1

                          },
                colors = ButtonDefaults.buttonColors(containerColor = getMaleButtonColor(value = genderChoice)),
                modifier = Modifier
                    .width(100.dp)

            ) {
                Text("Male")
                //Bottom Of Button
            }

            Spacer(modifier = Modifier.padding(20.dp))

            Button(
                onClick = {

                    Log.d("OUT", "OuterRide")

                    genderChoice = 0
                          },
                colors = ButtonDefaults.buttonColors(containerColor = getFemaleButtonColor(value = genderChoice)),
                modifier = Modifier
                    .width(100.dp)

            ) {
                Text("Female")
                //Bottom Of Button
            }

            Spacer(modifier = Modifier.padding())

        }





        Button(
            onClick = {
                Log.d("OUT", "OuterRide")

                //upon clicking next, internally set the brand new user Data
                signUpViewModel.setBasicNewUserData(newName = nameEntry, newAge = ageEntry.toInt(), newGender = genderChoice)

                //Go to the next view
                navController.navigate(route = Screen.ReviewNewUserInfoScreen.route)

            })
        {
            Text("Next ->")
            //Bottom Of Button
        }
        

    }










}


fun getMaleButtonColor(value:Int):Color {

    return if (value == 1){
        Color.Green
    }else{
        Color.Red
    }

}

fun getFemaleButtonColor(value:Int):Color {
    return if (value == 0){
        Color.Green
    }else{
        Color.Red
    }

}

