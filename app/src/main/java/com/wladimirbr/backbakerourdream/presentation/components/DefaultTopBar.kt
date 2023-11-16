package com.wladimirbr.backbakerourdream.presentation.components

import android.icu.text.CaseMap.Title
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

@Composable
fun DefaultTopBar(
    title: String,
    upAvailable: Boolean = false,
    navHostController: NavHostController? = null
) {
    TopAppBar(
        title = {
            Text(text = "Registro", fontSize = 16.sp)
        },
        backgroundColor = Color.White,
        navigationIcon = {
            if (upAvailable) {
                IconButton(onClick = { navHostController?.popBackStack() }) {
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = "",

                        )
                }
            }
        }
    )
}