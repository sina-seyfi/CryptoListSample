package com.sinaseyfi.presentation.ui.factories

import com.sinaseyfi.domain.enums.CryptoSortAttributeDataModel

object SortAttributeTextFactory {

    fun create(attr: CryptoSortAttributeDataModel): String =
        when(attr) {
            // I know, getting string resource is better.
            // But didn't have time to find a solution for getting string from resources in Compose
            CryptoSortAttributeDataModel.MARKET_CAP -> "Market Cap"
            CryptoSortAttributeDataModel.NAME -> "Name"
            CryptoSortAttributeDataModel.PRICE -> "Price"
            CryptoSortAttributeDataModel.CIRCULATING_SUPPLY -> "Circulating Supply"
        }

}