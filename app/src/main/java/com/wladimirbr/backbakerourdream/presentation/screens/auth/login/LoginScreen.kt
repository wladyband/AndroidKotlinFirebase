package com.wladimirbr.backbakerourdream.presentation.screens.auth.login


import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.wladimirbr.backbakerourdream.presentation.screens.auth.login.components.LoginContent
import com.wladimirbr.backbakerourdream.presentation.ui.theme.BackBakerOurDreamTheme


@Composable
fun LoginScreen(navHostController: NavHostController) {
    Scaffold(

    ) { paddingValues ->
        LoginContent(paddingValues, navHostController = navHostController,)
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    BackBakerOurDreamTheme {
        LoginScreen(rememberNavController())
    }
}