package com.sinaseyfi.remote.models.crypto.list

import com.sinaseyfi.domain.enums.CryptoSortAttributeDataModel
import com.sinaseyfi.remote.CIRCULATING_SUPPLY
import com.sinaseyfi.remote.MARKET_CAP
import com.sinaseyfi.remote.NAME
import com.sinaseyfi.remote.PRICE
import com.sinaseyfi.remote.base.RequestDtoMapper
import javax.inject.Inject

class CryptoSortAttributeRequestDtoMapper @Inject constructor():
    RequestDtoMapper<CryptoSortAttributeDataModel, CryptoSortAttributeRequestDto> {
    override fun mapToDto(request: CryptoSortAttributeDataModel): CryptoSortAttributeRequestDto =
        when(request) {
            CryptoSortAttributeDataModel.MARKET_CAP -> CryptoSortAttributeRequestDto(MARKET_CAP)
            CryptoSortAttributeDataModel.NAME -> CryptoSortAttributeRequestDto(NAME)
            CryptoSortAttributeDataModel.PRICE -> CryptoSortAttributeRequestDto(PRICE)
            CryptoSortAttributeDataModel.CIRCULATING_SUPPLY -> CryptoSortAttributeRequestDto(
                CIRCULATING_SUPPLY
            )
            else -> CryptoSortAttributeRequestDto(MARKET_CAP)
        }
}