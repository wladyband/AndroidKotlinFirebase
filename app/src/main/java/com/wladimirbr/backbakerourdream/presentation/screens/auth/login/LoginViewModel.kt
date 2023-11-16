package com.wladimirbr.backbakerourdream.presentation.screens.auth.login

import android.util.Patterns
import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.auth.FirebaseUser
import com.wladimirbr.backbakerourdream.domain.model.Response
import com.wladimirbr.backbakerourdream.domain.use_cases.auth.AuthUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(private val authUseCases: AuthUseCases) : ViewModel() {

    var state by mutableStateOf(LoginState())
        private set

    var errorMessager by mutableStateOf("")
        private set

    fun onEmailInput(email: String) {
        state = state.copy(email = email)
    }

    fun onPasswordnput(password: String) {
        state = state.copy(password = password)
    }

    private val _loginFlow = MutableStateFlow<Response<FirebaseUser>?>(null)
    val loginFlow: StateFlow<Response<FirebaseUser>?> = _loginFlow

    val currentUser = authUseCases.getCurrentUser()

    init {
        if (currentUser != null){
            _loginFlow.value = Response.Success(currentUser)
        }
    }

    fun loginUserAndValidateForm() {
        viewModelScope.launch {
            val isFormValid = validateFormLogin()
            if (isFormValid) {
                _loginFlow.value = Response.Loading
                val result = authUseCases.login(state.email, state.password)
                _loginFlow.value = result

            }
        }
    }

    private suspend fun validateFormLogin(): Boolean {
        return when {
            !Patterns.EMAIL_ADDRESS.matcher(state.email).matches() -> {
                errorMessager = "Este não é um email válido"
                false
            }
            state.password.length < 6 -> {
                errorMessager = "A senha deve ter pelo menos 6 caracteres"
                false
            }
            else -> {
                errorMessager = ""
                delay(3000) // Simulação de atraso (substitua pela lógica real).
                errorMessager = ""
                true
            }
        }
    }

    suspend fun clearErrorAfterDelay(errorToShow: String): String {
        delay(3000) // Atraso de 3 segundos (ajuste conforme necessário)
        return ""
    }

}
