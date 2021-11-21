package com.sinaseyfi.data.data_sources.remote

import androidx.paging.PagingSource
import com.sinaseyfi.data.base.RemoteDataSource
import com.sinaseyfi.domain.enums.CryptoSortAttributeDataModel
import com.sinaseyfi.domain.enums.SortDirectionDataModel
import com.sinaseyfi.domain.models.crypto.info.CryptoInfoDataModel
import com.sinaseyfi.domain.models.crypto.list.CryptoListingDataModel

interface CryptoRemoteDataSource: RemoteDataSource {

    companion object {
        const val NETWORK_PAGE_SIZE = 20
        const val INITIAL_LOAD_SIZE = 1
    }

    fun fetchCryptoListPage(sortAttribute: CryptoSortAttributeDataModel, sortDirectionDataModel: SortDirectionDataModel): PagingSource<Int, CryptoListingDataModel>
    suspend fun fetchInfo(cryptoId: Long): CryptoInfoDataModel

}