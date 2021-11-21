package com.sinaseyfi.remote.base

import com.google.gson.annotations.SerializedName
import com.sinaseyfi.remote.CREDIT_COUNT
import com.sinaseyfi.remote.ELAPSED
import com.sinaseyfi.remote.ERROR_CODE
import com.sinaseyfi.remote.ERROR_MESSAGE
import com.sinaseyfi.remote.TIMESTAMP

data class StatusDto(
    @SerializedName(TIMESTAMP)
    val timestamp: String,
    @SerializedName(ERROR_CODE)
    val errorCode: Long?,
    @SerializedName(ERROR_MESSAGE)
    val errorMessage: String?,
    @SerializedName(ELAPSED)
    val elapsed: Long,
    @SerializedName(CREDIT_COUNT)
    val creditCount: Long
): Dto