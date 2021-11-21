package com.sinaseyfi.remote.base

import com.google.gson.annotations.SerializedName
import com.sinaseyfi.remote.DATA
import com.sinaseyfi.remote.STATUS

data class BaseResponse<D>(
    @SerializedName(DATA)
    val data: D?,
    @SerializedName(STATUS)
    val status: StatusDto
)