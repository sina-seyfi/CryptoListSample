package com.sinaseyfi.remote.base

import com.sinaseyfi.domain.base.RequestDataModel

interface RequestDtoMapper<in Q : RequestDataModel, R: RequestDto> {
    fun mapToDto(request: Q): R
}