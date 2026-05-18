package com.plcoding.chat.database.entites

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.ForeignKey.Companion.CASCADE
import androidx.room.PrimaryKey

@Entity(
    foreignKeys = [
        ForeignKey(
            entity = ChatEntity::class,
            parentColumns = ["chatId"],
            childColumns = ["chatId"],
            onDelete = CASCADE
        )
    ]
)
data class ChatMessageEntity(
    @PrimaryKey
    val messageId: String,
    val chatId: String,
    val senderId: String,
    val content: String,
    val timeStamp: Long,
    val deliveryStatus: String,
    val deliveryStatusTimeStamp: Long = timeStamp
)
