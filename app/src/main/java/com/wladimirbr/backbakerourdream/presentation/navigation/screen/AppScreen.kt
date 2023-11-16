package com.wladimirbr.backbakerourdream.presentation.navigation.screen


sealed class AppScreen(val route: String) {

    object Login : AppScreen("login")
    object Register : AppScreen("register")
    object Profile : AppScreen("profile")
}
