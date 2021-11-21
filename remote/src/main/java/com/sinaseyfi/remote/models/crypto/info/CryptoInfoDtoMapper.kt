package com.sinaseyfi.remote.models.crypto.info

import com.sinaseyfi.domain.models.crypto.info.CryptoDetailsDataModel
import com.sinaseyfi.domain.models.crypto.info.CryptoInfoDataModel
import com.sinaseyfi.remote.base.DtoMapper
import javax.inject.Inject

class CryptoInfoDtoMapper @Inject constructor(
    private val cryptoDetailsDtoMapper: CryptoDetailsDtoMapper
): DtoMapper<CryptoInfoDto, CryptoInfoDataModel> {
    override fun mapToDataModel(dto: CryptoInfoDto?): CryptoInfoDataModel =
        CryptoInfoDataModel(
            HashMap<String, CryptoDetailsDataModel>().apply {
                dto!!.details.entries.forEach { pair -> put(pair.key, cryptoDetailsDtoMapper.mapToDataModel(pair.value)) }
            }
        )
}