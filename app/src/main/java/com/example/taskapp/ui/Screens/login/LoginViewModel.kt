package com.example.taskapp.ui.Screens.login

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor() : ViewModel() {
    val userName = mutableStateOf("")
    val password = mutableStateOf("")

    fun onTextChangeText(value: String, isUserName: Boolean) {
        if (isUserName) {
            this.userName.value = value
        } else {
            this.password.value = value
        }
    }
}