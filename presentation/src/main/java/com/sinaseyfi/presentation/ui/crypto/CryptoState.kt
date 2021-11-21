package com.sinaseyfi.presentation.ui.crypto

import com.sinaseyfi.presentation.ui.base.ViewState
import com.sinaseyfi.domain.enums.CryptoSortAttributeDataModel
import com.sinaseyfi.domain.enums.SortDirectionDataModel

data class CryptoState(
    val sortAttribute: CryptoSortAttributeDataModel = CryptoSortAttributeDataModel.MARKET_CAP,
    val sortDirDataModel: SortDirectionDataModel = SortDirectionDataModel.DESC
): ViewState