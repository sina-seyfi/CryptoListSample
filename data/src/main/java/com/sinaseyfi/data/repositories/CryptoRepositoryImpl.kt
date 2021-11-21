package com.sinaseyfi.data.repositories

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.sinaseyfi.data.data_sources.remote.CryptoRemoteDataSource
import com.sinaseyfi.domain.repositories.CryptoRepository
import com.sinaseyfi.domain.enums.CryptoSortAttributeDataModel
import com.sinaseyfi.domain.enums.SortDirectionDataModel
import com.sinaseyfi.domain.models.crypto.info.CryptoInfoDataModel
import com.sinaseyfi.domain.models.crypto.list.CryptoListingDataModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class CryptoRepositoryImpl @Inject constructor(
    private val cryptoRemoteDataSource: CryptoRemoteDataSource
): CryptoRepository {
    override fun getCryptoList(sortAttribute: CryptoSortAttributeDataModel, sortDirectionDataModel: SortDirectionDataModel): Flow<PagingData<CryptoListingDataModel>> =
        Pager(
            config = PagingConfig(
                pageSize = CryptoRemoteDataSource.NETWORK_PAGE_SIZE,
                enablePlaceholders = true
            ),
            pagingSourceFactory = { cryptoRemoteDataSource.fetchCryptoListPage(sortAttribute, sortDirectionDataModel) }
        ).flow

    override suspend fun getCryptoDetails(cryptoId: Long): CryptoInfoDataModel =
        cryptoRemoteDataSource.fetchInfo(cryptoId)

}