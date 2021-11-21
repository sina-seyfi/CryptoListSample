package com.sinaseyfi.domain.use_cases

import androidx.paging.PagingData
import com.sinaseyfi.domain.base.BasePagingFlowUseCase
import com.sinaseyfi.domain.enums.CryptoSortAttributeDataModel
import com.sinaseyfi.domain.enums.SortDirectionDataModel
import com.sinaseyfi.domain.models.crypto.list.CryptoListingDataModel
import com.sinaseyfi.domain.repositories.CryptoRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetCryptoListPagingFlowUseCase @Inject constructor(
    private val cryptoRepository: CryptoRepository
): BasePagingFlowUseCase<Pair<CryptoSortAttributeDataModel, SortDirectionDataModel>, CryptoListingDataModel>() {
    override fun perform(request: Pair<CryptoSortAttributeDataModel, SortDirectionDataModel>): Flow<PagingData<CryptoListingDataModel>> =
        cryptoRepository.getCryptoList(request.first, request.second)
}