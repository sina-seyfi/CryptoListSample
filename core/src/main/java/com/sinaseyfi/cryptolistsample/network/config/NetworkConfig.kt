package com.sinaseyfi.cryptolistsample.network.config

import com.sinaseyfi.cryptolistsample.network.NetworkConfiguration
import okhttp3.Interceptor
import okhttp3.logging.HttpLoggingInterceptor
import javax.inject.Inject

class NetworkConfig @Inject constructor(
    private val mainInterceptor: MainInterceptor
): NetworkConfiguration {
    override fun getInterceptors(): List<Interceptor> =
        listOf(
            mainInterceptor,
            HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BODY }
        )
}