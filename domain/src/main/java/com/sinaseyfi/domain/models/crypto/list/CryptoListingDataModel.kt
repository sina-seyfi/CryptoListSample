package com.sinaseyfi.domain.models.crypto.list

import com.sinaseyfi.domain.base.DataModel

data class CryptoListingDataModel(
    val id: Long,
    val name: String,
    val symbol: String,
    val slug: String,
    val cmcRank: Int,
    val numMarketPairs: Int,
    val circulatingSupply: Double,
    val totalSupply: Double,
    val maxSupply: Double,
    val lastUpdated: String,
    val dateAdded: String,
    val tags: List<String>,
    val quote: Map<String, CryptoQuoteDataModel>
) : DataModel

data class CryptoQuoteDataModel(
    val price: Double,
    val volume24h: Double,
    val volumeChange24h: Double,
    val percentChange1h: Double,
    val percentChange24h: Double,
    val percentChange7d: Double,
    val marketCap: Double,
    val marketCapDominance: Double,
    val fullyDilutedMarketCap: Double,
    val lastUpdated: String
): DataModel