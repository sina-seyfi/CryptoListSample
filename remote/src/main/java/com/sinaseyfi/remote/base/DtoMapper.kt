package com.sinaseyfi.remote.base

import com.sinaseyfi.domain.base.DataModel

interface DtoMapper<in T: Dto, out D: DataModel> {

    fun mapToDataModel(dto: T?): D

}