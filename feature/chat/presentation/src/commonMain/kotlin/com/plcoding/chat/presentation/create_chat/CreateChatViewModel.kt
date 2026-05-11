package com.plcoding.chat.presentation.create_chat

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class CreateChatViewModel : ViewModel() {

    private val _state = MutableStateFlow(CreateChatState())
    val state = _state.asStateFlow()


    fun onAction(action: CreateChatAction) {
        when (action) {
            CreateChatAction.OnAddClick -> Unit
            CreateChatAction.OnCreateChatClick -> Unit
            CreateChatAction.OnDismissDialog -> Unit
        }
    }

}