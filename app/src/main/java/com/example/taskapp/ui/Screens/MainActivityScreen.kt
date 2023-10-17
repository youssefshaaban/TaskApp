package com.example.taskapp.ui.Screens

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

import com.example.taskapp.routing.Screen
import com.example.taskapp.ui.Screens.HomeScreen.HomeScreen
import com.example.taskapp.ui.Screens.login.LoginScreen


@Composable
 fun MainActivityScreen(
    navController: NavHostController,
) {
    NavHost(
        navController = navController,
        startDestination = Screen.Login.route
    ) {
        composable(Screen.Login.route) {
            LoginScreen(navController)
        }
        composable(Screen.SecondScreen.route+"/{userName}"){backStackEntry->
            HomeScreen(userName = backStackEntry.arguments?.getString("userName").orEmpty() )
        }
    }
}
