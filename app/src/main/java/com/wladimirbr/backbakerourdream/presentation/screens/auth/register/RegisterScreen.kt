package com.wladimirbr.backbakerourdream.presentation.screens.auth.register

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.wladimirbr.backbakerourdream.presentation.components.DefaultTopBar
import com.wladimirbr.backbakerourdream.presentation.screens.auth.login.LoginScreen
import com.wladimirbr.backbakerourdream.presentation.screens.auth.register.components.RegisterContent
import com.wladimirbr.backbakerourdream.presentation.ui.theme.BackBakerOurDreamTheme

@Composable
fun RegisterScreen(navHostController: NavHostController) {
    Scaffold(
        topBar = {
         DefaultTopBar(title = "Registro",
             upAvailable = true,
             navHostController)
        },

        ) { paddingValues ->
        RegisterContent(paddingValues = paddingValues)
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    BackBakerOurDreamTheme {
        RegisterScreen(rememberNavController())
    }
}