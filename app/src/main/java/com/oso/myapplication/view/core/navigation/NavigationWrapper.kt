package com.oso.myapplication.view.core.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.oso.myapplication.view.auth.login.LoginScreen

@Composable
fun NavigationWrapper(){

    val navController: NavHostController = rememberNavController()
    NavHost(navController = navController, startDestination = Login) {
        composable <Login>{
            LoginScreen()
        }
    }
}