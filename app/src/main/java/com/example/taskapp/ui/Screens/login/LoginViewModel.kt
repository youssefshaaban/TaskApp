package com.example.taskapp.ui.Screens.login

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor() : ViewModel() {
    val userName = mutableStateOf("")
    val password = mutableStateOf("")
    val errorUserName = mutableStateOf(false)
    fun onTextChangeText(value: String, isUserName: Boolean) {
        if (isUserName) {
            errorUserName.value = userName.value.isEmpty()
            this.userName.value = value
        } else {
            this.password.value = value
        }
    }

    fun login(): Boolean {
        if (userName.value.isEmpty()) {
            errorUserName.value = true
            return false
        }
        return true;
    }
}