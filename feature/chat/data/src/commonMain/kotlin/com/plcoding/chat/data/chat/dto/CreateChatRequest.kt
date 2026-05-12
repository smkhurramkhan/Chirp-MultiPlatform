package com.plcoding.chat.data.chat.dto

import kotlinx.serialization.Serializable

@Serializable
data class CreateChatRequest(
    val otherUserIds: List<String>
)
