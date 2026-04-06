package com.plcoding.core.domain.auth

import kotlinx.coroutines.flow.Flow

interface SessionStorage {

    fun observeAuthInfo9(): Flow<AuthInfo?>
    suspend fun set(info: AuthInfo?)
}