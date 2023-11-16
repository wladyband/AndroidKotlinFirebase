package com.wladimirbr.backbakerourdream.presentation.screens.profile

import android.annotation.SuppressLint
import androidx.compose.material.Scaffold
import androidx.compose.material.Text

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun ProfileScreen(navHostController: NavHostController) {
    Scaffold(
        topBar = {},
        content = {
            Text(text = "ProfileScreen")
        },
        bottomBar = {}
    )
}