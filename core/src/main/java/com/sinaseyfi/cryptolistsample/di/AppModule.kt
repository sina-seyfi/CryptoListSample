package com.sinaseyfi.cryptolistsample.di

import com.sinaseyfi.cryptolistsample.AppLogger
import com.sinaseyfi.log.Logger
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class AppModule {

    @Binds
    @Singleton
    abstract fun bindLogger(appLogger: AppLogger): Logger

}