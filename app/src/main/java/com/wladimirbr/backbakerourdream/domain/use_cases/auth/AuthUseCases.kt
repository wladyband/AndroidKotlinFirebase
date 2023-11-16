package com.wladimirbr.backbakerourdream.domain.use_cases.auth

data class AuthUseCases(
    val getCurrentUser: GetCurrentUser,
    val login: Login
)