package com.wladimirbr.backbakerourdream.presentation.screens.auth.login.components

import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector

@Composable
fun DefaultButton(
    modifier: Modifier,
    text: String,
    colorText: Color,
    onClick: () -> Unit,
    colorButton: Color = Color.Unspecified,
    icon: ImageVector = Icons.Default.ArrowForward
) {
    Button(

        modifier = modifier,
        onClick = { onClick() },
        colors = ButtonDefaults.buttonColors(backgroundColor = colorButton)
    ) {
        Icon(imageVector = icon, contentDescription = "", tint = Color.White)
        Text(text = text, color = colorText)
    }
}