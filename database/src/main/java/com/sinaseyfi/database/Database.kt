package com.sinaseyfi.database

import android.content.Context
import androidx.room.Room
import javax.inject.Inject

class Database @Inject constructor(private val context: Context) {

    val database: AppDatabase by lazy {
        Room.databaseBuilder(context, AppDatabase::class.java, BuildConfig.SCHEMA_NAME).fallbackToDestructiveMigration().build()
    }

}