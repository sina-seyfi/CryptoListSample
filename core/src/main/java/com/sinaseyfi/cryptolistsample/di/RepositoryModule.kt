package com.sinaseyfi.cryptolistsample.di

import com.sinaseyfi.data.repositories.CryptoRepositoryImpl
import com.sinaseyfi.domain.repositories.CryptoRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module(includes = [RepositoryModule.Binder::class])
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Module
    @InstallIn(SingletonComponent::class)
    abstract class Binder {

        @Binds
        @Singleton
        abstract fun bindCryptoRepository(cryptoRepositoryImpl: CryptoRepositoryImpl): CryptoRepository

    }

}