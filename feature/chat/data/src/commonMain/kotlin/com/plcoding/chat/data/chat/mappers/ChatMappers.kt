package com.plcoding.chat.data.chat.mappers

import com.plcoding.chat.data.chat.dto.ChatDto
import com.plcoding.chat.domain.models.Chat
import kotlin.time.Instant

fun ChatDto.toDomain(): Chat{
    return Chat(
        id = id,
        participants = participants.map { it.toDomain() },
        lastActivityAt = Instant.parse(lastActivityAt),
        lastMessage = lastMessage?.toDomain()
    )
}