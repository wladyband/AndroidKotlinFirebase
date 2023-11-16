package com.wladimirbr.backbakerourdream.presentation.screens.auth.register

data class RegisterState(
    val name: String = "",
    val email: String = "",
    val password: String = "",
    val confirmationPassword: String = "",
)
