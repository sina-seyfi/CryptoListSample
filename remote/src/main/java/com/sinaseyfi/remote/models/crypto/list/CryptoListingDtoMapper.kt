package com.sinaseyfi.remote.models.crypto.list

import com.sinaseyfi.domain.models.crypto.list.CryptoListingDataModel
import com.sinaseyfi.domain.models.crypto.list.CryptoQuoteDataModel
import com.sinaseyfi.remote.base.DtoMapper
import javax.inject.Inject

class CryptoListingDtoMapper @Inject constructor(
    private val cryptoQuoteDtoMapper: CryptoQuoteDtoMapper
): DtoMapper<CryptoListingDto, CryptoListingDataModel> {
    override fun mapToDataModel(dto: CryptoListingDto?): CryptoListingDataModel =
        CryptoListingDataModel(
            dto!!.id,
            dto.name,
            dto.symbol,
            dto.slug,
            dto.cmcRank,
            dto.numMarketPairs,
            dto.circulatingSupply,
            dto.totalSupply,
            dto.maxSupply,
            dto.lastUpdated,
            dto.dateAdded,
            dto.tags,
            HashMap<String, CryptoQuoteDataModel>().apply {
                dto.quote.entries.forEach { pair -> put(pair.key, cryptoQuoteDtoMapper.mapToDataModel(pair.value)) }
            }
        )
}