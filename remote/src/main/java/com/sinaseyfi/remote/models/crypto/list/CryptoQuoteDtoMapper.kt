package com.sinaseyfi.remote.models.crypto.list

import com.sinaseyfi.domain.models.crypto.list.CryptoQuoteDataModel
import com.sinaseyfi.remote.base.DtoMapper
import javax.inject.Inject

class CryptoQuoteDtoMapper @Inject constructor(): DtoMapper<CryptoQuoteDto, CryptoQuoteDataModel> {
    override fun mapToDataModel(dto: CryptoQuoteDto?): CryptoQuoteDataModel =
        CryptoQuoteDataModel(
            dto!!.price,
            dto.volume24h,
            dto.volumeChange24h,
            dto.percentChange1h,
            dto.percentChange24h,
            dto.percentChange7d,
            dto.marketCap,
            dto.marketCapDominance,
            dto.fullyDilutedMarketCap,
            dto.lastUpdated
        )
}