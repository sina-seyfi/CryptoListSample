package com.sinaseyfi.remote.base

open class ResponseWrapper<out T> {
    data class Success<out T>(val data: T?) :
        ResponseWrapper<T>()

    data class Error(val exception: Exception) : ResponseWrapper<Nothing>()
    class Complete : ResponseWrapper<Nothing>()
}