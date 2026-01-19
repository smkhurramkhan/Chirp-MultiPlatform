package com.plcoding.core.domain.util

sealed interface DataError: Error{
    enum class Remote: DataError{  //Error from remote like no internet, token expired  etc
        BAD_REQUEST,
        REQUEST_TIMEOUT,
        UNAUTHORIZED,
        FORBIDDEN,
        NOT_FOUND,
        CONFLICT,
        TOO_MANY_REQUESTS,
        NO_INTERNET,
        PAYLOAD_TOO_LARGE,
        SERVER_ERROR,
        SERVICE_UNAVAILABLE,
        SERIALIZATION,
        UNKNOWN
    }
    enum class Local{ // Error from local like low storage
        DISK_FULL,
        FILE_NOT_FOUND,
        UNKNOWN
    }
}

