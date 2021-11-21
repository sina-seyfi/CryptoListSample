package com.sinaseyfi.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.sinaseyfi.database.entities.Crypto


@Database(
    version = BuildConfig.DATABASE_VERSION,
    entities = [Crypto::class],
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {
}