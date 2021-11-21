package com.sinaseyfi.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.sinaseyfi.database.ID
import com.sinaseyfi.database.NAME

@Entity
data class Crypto(
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = ID)
    val id: Long,
    @ColumnInfo(name = NAME)
    val name: String? = null,
)