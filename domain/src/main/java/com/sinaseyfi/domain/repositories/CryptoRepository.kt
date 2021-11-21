package com.sinaseyfi.domain.repositories

import androidx.paging.PagingData
import com.sinaseyfi.domain.enums.CryptoSortAttributeDataModel
import com.sinaseyfi.domain.enums.SortDirectionDataModel
import com.sinaseyfi.domain.models.crypto.info.CryptoInfoDataModel
import com.sinaseyfi.domain.models.crypto.list.CryptoListingDataModel
import kotlinx.coroutines.flow.Flow

interface CryptoRepository {
    fun getCryptoList(sortAttribute: CryptoSortAttributeDataModel, sortDirectionDataModel: SortDirectionDataModel): Flow<PagingData<CryptoListingDataModel>>
    suspend fun getCryptoDetails(cryptoId: Long): CryptoInfoDataModel
}