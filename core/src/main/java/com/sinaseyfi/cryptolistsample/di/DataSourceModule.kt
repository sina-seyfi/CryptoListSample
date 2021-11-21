package com.sinaseyfi.cryptolistsample.di

import com.sinaseyfi.data.data_sources.remote.CryptoRemoteDataSource
import com.sinaseyfi.remote.models.crypto.CryptoApiService
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module(includes = [DataSourceModule.Binder::class])
@InstallIn(SingletonComponent::class)
object DataSourceModule {

    @Module
    @InstallIn(SingletonComponent::class)
    abstract class Binder {

        @Binds
        @Singleton
        abstract fun bindCryptoApi(cryptoApiService: CryptoApiService): CryptoRemoteDataSource

    }

}