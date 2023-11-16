package com.wladimirbr.backbakerourdream.presentation.screens.auth.register


import android.util.Patterns
import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RegisterModel @Inject constructor() : ViewModel() {

    var state by mutableStateOf(RegisterState())


    var errorMessager by mutableStateOf("")
        private set

    fun onNameInput(input: String) {
        state = state.copy(name = input)
    }


    fun onEmailInput(input: String) {
        state = state.copy(email = input)
    }


    fun onPasswordInput(input: String) {
        state = state.copy(password = input)
    }

    fun onConfirmationPassword(input: String) {
        state = state.copy(confirmationPassword = input)
    }

    fun validateForm() = viewModelScope.launch {
        when {
            state.name.isEmpty() -> errorMessager = "É necessário o nome"
            state.email.isEmpty() -> errorMessager = "É necessário o e-mail"
            state.password.isEmpty() -> errorMessager = "É necessário a senha"
            state.confirmationPassword.isEmpty() -> errorMessager = "É necessário a confirmação da senha"
            !Patterns.EMAIL_ADDRESS.matcher(state.email).matches() -> errorMessager = "Este não é um email válido"
            state.password.length < 6 -> errorMessager = "A senha deve ter pelo menos 6 caracteres"
            state.confirmationPassword.length < 6 -> errorMessager = "A confirmação de senha deve ter pelo menos 6 caracteres"
            else -> errorMessager = ""
        }

        delay(3000)
        errorMessager = ""
    }

}