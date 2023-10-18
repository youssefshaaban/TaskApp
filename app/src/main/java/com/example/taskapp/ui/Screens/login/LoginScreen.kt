package com.example.taskapp.ui.Screens.login

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.taskapp.routing.Screen
import com.example.taskapp.ui.components.ContentTextField
import com.example.taskapp.ui.components.TextFiledPassword

@Composable
fun LoginScreen(navigationController: NavHostController) {
    val viewModel: LoginViewModel = hiltViewModel()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ContentTextField(
            modifier = Modifier.fillMaxWidth(),
            label = "userName",
            text = viewModel.userName.value,
            message = "filed is required",
            isError = viewModel.errorUserName.value,
            onTextChange = {
                viewModel.onTextChangeText(it, true)
            })

        TextFiledPassword(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 10.dp),
            label = "password",
            password = viewModel.password.value,
            onTextChange = {
                viewModel.onTextChangeText(it, false)
            })

        Button(modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 10.dp), onClick = {
            if (viewModel.login()) {
                navigationController.navigate(
                    Screen.SecondScreen.route + "/${viewModel.userName.value}"
                )
            }
        }) {
            Text(text = "Login")
        }
    }
}

