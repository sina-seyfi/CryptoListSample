package com.sinaseyfi.database

import com.sinaseyfi.domain.base.DataModel

interface TableMapper<T : Table, D : DataModel> {
    fun mapToData(table: T): D
    fun mapToTable(data: D): T
}