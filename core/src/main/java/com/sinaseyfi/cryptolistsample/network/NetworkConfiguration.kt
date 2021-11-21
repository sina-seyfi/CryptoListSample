package com.sinaseyfi.cryptolistsample.network

import okhttp3.Interceptor

interface NetworkConfiguration {
    fun getInterceptors() : List<Interceptor>
}