package com.wladimirbr.backbakerourdream.presentation.navigation.graph


import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.wladimirbr.backbakerourdream.presentation.navigation.Graph
import com.wladimirbr.backbakerourdream.presentation.navigation.screen.AppScreen
import com.wladimirbr.backbakerourdream.presentation.screens.auth.login.LoginScreen
import com.wladimirbr.backbakerourdream.presentation.screens.auth.register.RegisterScreen
import com.wladimirbr.backbakerourdream.presentation.screens.profile.ProfileScreen


fun NavGraphBuilder.AppNavGraph(navController: NavHostController) {
    navigation(route = Graph.AUTH, startDestination = AppScreen.Login.route) {
        composable(route = AppScreen.Login.route) {
            LoginScreen(navController)
        }
        composable(route = AppScreen.Register.route) {
            RegisterScreen(navController)
        }

        composable(route = AppScreen.Profile.route) {
            ProfileScreen(navController)
        }
    }
}