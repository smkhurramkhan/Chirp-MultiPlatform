package com.plcoding.chat.data.chat.mappers

import com.plcoding.chat.data.chat.dto.ChatParticipantDto
import com.plcoding.chat.domain.models.ChatParticipant

fun ChatParticipantDto.toDomain(): ChatParticipant{
    return ChatParticipant(
        userId = userId,
        username = username,
        profilePictureUrl = profilePicture
    )
}