package com.plcoding.chat.presentation.create_chat

import androidx.compose.foundation.text.input.TextFieldState
import com.plcoding.core.designsystem.components.avatar.ChatParticipantUi
import com.plcoding.core.presentation.util.UiText

data class CreateChatState(
    val queryTextState: TextFieldState = TextFieldState(),
    val selectedChatParticipant: List<ChatParticipantUi> = emptyList(),
    val isCreatingChat: Boolean = false,
    val isAddingParticipants: Boolean = false,
    val isLoadingParticipants: Boolean = false,
    val canAddParticipants: Boolean = false,
    val currentSearchResult: ChatParticipantUi? = null,
    val searchError: UiText? = null
)
