package com.sinaseyfi.remote.models.crypto.list

import com.sinaseyfi.domain.enums.SortDirectionDataModel
import com.sinaseyfi.remote.base.RequestDtoMapper
import javax.inject.Inject

class SortDirectionRequestDtoMapper @Inject constructor():
    RequestDtoMapper<SortDirectionDataModel, SortDirectionRequestDto> {
    override fun mapToDto(request: SortDirectionDataModel): SortDirectionRequestDto =
        when(request) {
            SortDirectionDataModel.ASC -> SortDirectionRequestDto("asc")
            SortDirectionDataModel.DESC -> SortDirectionRequestDto("desc")
        }
}