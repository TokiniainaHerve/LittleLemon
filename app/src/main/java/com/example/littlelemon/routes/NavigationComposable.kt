package com.example.littlelemon.routes

import androidx.compose.runtime.Composable

import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.littlelemon.composables.HomeScreen
import com.example.littlelemon.composables.OnboardingScreen
import com.example.littlelemon.composables.ProfileScreen

@Composable
fun Navigation(navController: NavHostController){
    NavHost(
        navController = navController,
        startDestination = Onboarding.route
    ) {
        composable(Onboarding.route) {
            OnboardingScreen(navController)
        }
        composable(Home.route) {
            HomeScreen(navController = navController)
        }
        composable(Profile.route) {
            ProfileScreen(navController = navController)
        }


    }

}