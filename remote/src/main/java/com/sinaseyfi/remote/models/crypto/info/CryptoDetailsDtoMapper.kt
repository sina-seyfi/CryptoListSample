package com.sinaseyfi.remote.models.crypto.info

import com.sinaseyfi.domain.models.crypto.info.CryptoDetailsDataModel
import com.sinaseyfi.remote.base.DtoMapper
import javax.inject.Inject

class CryptoDetailsDtoMapper @Inject constructor(
    private val cryptoURLDtoMapper: CryptoURLDtoMapper
): DtoMapper<CryptoDetailsDto, CryptoDetailsDataModel> {
    override fun mapToDataModel(dto: CryptoDetailsDto?): CryptoDetailsDataModel =
        CryptoDetailsDataModel(
            dto!!.id,
            cryptoURLDtoMapper.mapToDataModel(dto.urls),
            dto.logo,
            dto.name,
            dto.symbol,
            dto.slug,
            dto.description,
            dto.dateAdded,
            dto.tags,
            dto.category
        )
}