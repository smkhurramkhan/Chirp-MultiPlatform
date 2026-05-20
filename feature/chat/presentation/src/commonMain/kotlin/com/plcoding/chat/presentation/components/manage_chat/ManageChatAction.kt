package com.plcoding.chat.presentation.components.manage_chat

import com.plcoding.chat.domain.models.ChatParticipant

sealed interface ManageChatAction {
    data object OnAddClick: ManageChatAction
    data object OnDismissDialog: ManageChatAction
    data object OnPrimaryActionClick: ManageChatAction

    sealed interface ChatParticipants: ManageChatAction{
        data class OnSelectChat(val chatId: String?): ManageChatAction
    }
}