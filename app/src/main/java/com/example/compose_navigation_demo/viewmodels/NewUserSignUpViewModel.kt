package com.example.compose_navigation_demo.viewmodels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.compose_navigation_demo.data_models.SignUpScreensData
import com.example.compose_navigation_demo.data_models.UserData

//This is the new user sign up process view model. Its in charge of controlling
// and saving values for the sign up screens process.
class NewUserSignUpViewModel:ViewModel() {

    private val _newUserData = MutableLiveData<SignUpScreensData>()

    val newUserData: LiveData<SignUpScreensData> get() = _newUserData


    //Function to update the the user text entry value
   fun setBasicNewUserData(newName:String, newAge:Int, newGender:Int) {

       Log.d("Updated Sign Up Data", "Name: $newName, Age: $newAge, Gender: $newGender")

        val newScreen = SignUpScreensData(newName, newAge, newGender)

        _newUserData.postValue(newScreen)

        Log.d("Updated Sign Up real Data", "Name: ${newUserData.value?.enteringName}, Age: ${newUserData.value?.enteringAge}, Gender: ${newUserData.value?.enteringGender}")
   }




}