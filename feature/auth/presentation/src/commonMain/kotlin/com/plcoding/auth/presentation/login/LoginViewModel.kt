package com.plcoding.auth.presentation.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.plcoding.core.domain.auth.AuthService
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.stateIn

class LoginViewModel(
    private val authService: AuthService
) : ViewModel() {

    private val _state = MutableStateFlow(LoginState())
    val state = _state.onStart {
    }.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5_000L),
        initialValue = LoginState()
    )


    fun onAction(action: LoginAction) {
        when (action) {
            LoginAction.OnForgotPasswordClick -> Unit
            LoginAction.OnLoginClick -> Unit
            LoginAction.OnSignUpClick -> Unit
            LoginAction.OnTogglePasswordVisibility -> Unit
        }
    }
}