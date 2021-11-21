package com.sinaseyfi.remote.adapter

interface CallAdapter<R> {
    suspend fun execute(): R
}