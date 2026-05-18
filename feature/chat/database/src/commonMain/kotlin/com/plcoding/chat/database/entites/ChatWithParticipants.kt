package com.plcoding.chat.database.entites

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation

data class ChatWithParticipants(
    @Embedded
    val chat: ChatEntity,

    @Relation(
        parentColumn = "chatId",
        entityColumn = "userId",
        associateBy = Junction(ChatParticipantCrossRef::class)
    )
    val participant:List<ChatParticipantEntity>
)


data class ChatInfoEntity(
    @Embedded
    val chat: ChatEntity,

    @Relation(
        parentColumn = "chatId",
        entityColumn = "userId",
        associateBy = Junction(ChatParticipantCrossRef::class)
    )
    val participant:List<ChatParticipantEntity>,

    @Relation(
        parentColumn = "chatId",
        entityColumn = "chatId",
        entity= ChatMessageEntity::class
    )
    val messagesWithSender: List<MessageWithSender>
)
