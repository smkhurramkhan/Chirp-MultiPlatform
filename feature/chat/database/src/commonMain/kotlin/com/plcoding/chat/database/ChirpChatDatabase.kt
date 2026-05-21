package com.plcoding.chat.database

import androidx.room.ConstructedBy
import androidx.room.Database
import androidx.room.RoomDatabase
import com.plcoding.chat.database.dao.ChatDao
import com.plcoding.chat.database.dao.ChatMessageDao
import com.plcoding.chat.database.dao.ChatParticipantDao
import com.plcoding.chat.database.dao.ChatParticipantsCrossRefDao
import com.plcoding.chat.database.entites.ChatEntity
import com.plcoding.chat.database.entites.ChatMessageEntity
import com.plcoding.chat.database.entites.ChatParticipantCrossRef
import com.plcoding.chat.database.entites.ChatParticipantEntity
import com.plcoding.chat.database.view.LastMessageView


@Database(
    entities = [
        ChatEntity::class,
        ChatParticipantEntity::class,
        ChatMessageEntity::class,
        ChatParticipantCrossRef::class
    ],
    views = [
        LastMessageView::class
    ],
    version = 1
)
@ConstructedBy(ChirpChatDatabaseConstructor::class)
abstract class ChirpChatDatabase : RoomDatabase() {

    abstract val chatDao: ChatDao
    abstract val chatParticipantDao: ChatParticipantDao
    abstract val chatMessageDao: ChatMessageDao
    abstract val chatParticipantCrossRefDao: ChatParticipantsCrossRefDao

    companion object {
        const val DB_NAME = "chirp.db"
    }
}