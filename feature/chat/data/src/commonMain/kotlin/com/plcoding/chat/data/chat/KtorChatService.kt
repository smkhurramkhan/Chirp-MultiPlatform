package com.plcoding.chat.data.chat

import com.plcoding.chat.data.chat.dto.ChatDto
import com.plcoding.chat.data.chat.dto.CreateChatRequest
import com.plcoding.chat.data.chat.mappers.toDomain
import com.plcoding.chat.domain.chat.ChatService
import com.plcoding.chat.domain.models.Chat
import com.plcoding.core.data.networking.post
import com.plcoding.core.domain.util.DataError
import com.plcoding.core.domain.util.Result
import com.plcoding.core.domain.util.map
import io.ktor.client.HttpClient

class KtorChatService(
    private val httpClient: HttpClient
): ChatService {
    override suspend fun createChat(otherUserId: List<String>): Result<Chat, DataError.Remote> {
        return httpClient.post<CreateChatRequest, ChatDto>(
            route = "/chat",
            body = CreateChatRequest(otherUserIds = otherUserId)
        ).map { it.toDomain() }
    }

}