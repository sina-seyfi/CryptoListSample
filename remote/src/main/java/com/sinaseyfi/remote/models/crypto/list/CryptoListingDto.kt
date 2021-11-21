package com.sinaseyfi.remote.models.crypto.list

import com.google.gson.annotations.SerializedName
import com.sinaseyfi.remote.*
import com.sinaseyfi.remote.base.Dto

data class CryptoListingDto(
    @SerializedName(ID)
    val id: Long,
    @SerializedName(NAME)
    val name: String,
    @SerializedName(SYMBOL)
    val symbol: String,
    @SerializedName(SLUG)
    val slug: String,
    @SerializedName(CMC_RANK)
    val cmcRank: Int,
    @SerializedName(NUM_MARKET_PAIRS)
    val numMarketPairs: Int,
    @SerializedName(CIRCULATING_SUPPLY)
    val circulatingSupply: Double,
    @SerializedName(TOTAL_SUPPLY)
    val totalSupply: Double,
    @SerializedName(MAX_SUPPLY)
    val maxSupply: Double,
    @SerializedName(LAST_UPDATED)
    val lastUpdated: String,
    @SerializedName(DATE_ADDED)
    val dateAdded: String,
    @SerializedName(TAGS)
    val tags: List<String>,
    @SerializedName(QUOTE)
    val quote: Map<String, CryptoQuoteDto>
) : Dto

data class CryptoQuoteDto(
    @SerializedName(PRICE)
    val price: Double,
    @SerializedName(VOLUME_24H)
    val volume24h: Double,
    @SerializedName(VOLUME_CHANGE_24H)
    val volumeChange24h: Double,
    @SerializedName(PERCENT_CHANGE_1H)
    val percentChange1h: Double,
    @SerializedName(PERCENT_CHANGE_24H)
    val percentChange24h: Double,
    @SerializedName(PERCENT_CHANGE_7D)
    val percentChange7d: Double,
    @SerializedName(MARKET_CAP)
    val marketCap: Double,
    @SerializedName(MARKET_CAP_DOMINANCE)
    val marketCapDominance: Double,
    @SerializedName(FULLY_DILUTED_MARKET_CAP)
    val fullyDilutedMarketCap: Double,
    @SerializedName(LAST_UPDATED)
    val lastUpdated: String
): Dto