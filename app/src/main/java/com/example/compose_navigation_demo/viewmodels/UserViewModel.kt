package com.example.compose_navigation_demo.viewmodels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.compose_navigation_demo.data_models.SignUpScreensData
import com.example.compose_navigation_demo.data_models.UserData


//This is the USER VIEW MODEL
//It contains All data assigners and relevant functions for the user
class UserViewModel:ViewModel() {

    private val _user = MutableLiveData<UserData>()

    val user: LiveData<UserData> get() = _user

    fun setInternalUserData(newName: String, newAge:Int, newGender:Int){

        Log.d("Updated New User Data", "Name: $newName, Age: $newAge, Gender: $newGender")

        val newUserData = UserData(newName, newAge, newGender)

        _user.postValue(newUserData)


    }


}