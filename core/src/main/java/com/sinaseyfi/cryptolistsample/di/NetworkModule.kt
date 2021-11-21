package com.sinaseyfi.cryptolistsample.di

import com.google.gson.GsonBuilder
import com.sinaseyfi.BuildConfig
import com.sinaseyfi.cryptolistsample.network.NetworkConfiguration
import com.sinaseyfi.cryptolistsample.network.config.NetworkConfig
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module(includes = [NetworkModule.Binder::class])
@InstallIn(SingletonComponent::class)
object NetworkModule {

    private const val READ_TIMEOUT: Long = 30
    private const val CONNECTION_TIMEOUT: Long = 15
    private const val WRITE_TIMEOUT: Long = 15

    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BuildConfig.API_BASE_URL)
            .addConverterFactory(
                GsonConverterFactory.create(
                    GsonBuilder()
                        .setLenient()
                        .create()
                )
            )
            .client(okHttpClient)
            .build()
    }

    @Provides
    @Singleton
    fun provideOkHttpClient(networkConfiguration: NetworkConfiguration): OkHttpClient {
        val okHttpBuilder = OkHttpClient.Builder()
        networkConfiguration.getInterceptors().forEach {
            okHttpBuilder.addInterceptor(it)
        }
        okHttpBuilder.readTimeout(READ_TIMEOUT, TimeUnit.SECONDS)
        okHttpBuilder.writeTimeout(WRITE_TIMEOUT, TimeUnit.SECONDS)
        okHttpBuilder.connectTimeout(CONNECTION_TIMEOUT, TimeUnit.SECONDS)
        return okHttpBuilder.build()
    }

    @Module
    @InstallIn(SingletonComponent::class)
    abstract class Binder {
        @Binds
        @Singleton
        abstract fun bindNetworkConfiguration(networkConfig: NetworkConfig): NetworkConfiguration
    }

}