package com.sinaseyfi.presentation.ui.crypto

import androidx.lifecycle.viewModelScope
import androidx.paging.*
import com.sinaseyfi.domain.use_cases.GetCryptoListPagingFlowUseCase
import com.sinaseyfi.presentation.ui.base.BaseViewModel
import com.sinaseyfi.domain.enums.CryptoSortAttributeDataModel
import com.sinaseyfi.domain.enums.SortDirectionDataModel
import com.sinaseyfi.domain.models.crypto.list.CryptoListingDataModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CryptoViewModel @Inject constructor(
    private val getCryptoListPagingFlowUseCase: GetCryptoListPagingFlowUseCase
): BaseViewModel<CryptoState>(CryptoState()) {

    private val _sortAttribute = MutableStateFlow(CryptoSortAttributeDataModel.MARKET_CAP)

    private val _sortDirection = MutableStateFlow(SortDirectionDataModel.DESC)

    init {
        viewModelScope.launch {
            combine(_sortAttribute, _sortDirection) { attr, direction ->
                CryptoState(attr, direction)
            }.collect {
                _viewState.value = it
            }
        }
    }

    fun getCryptoPagedList(
        sortAttributeDataModel: CryptoSortAttributeDataModel = CryptoSortAttributeDataModel.MARKET_CAP,
        directionDataModel: SortDirectionDataModel = SortDirectionDataModel.DESC
    ): Flow<PagingData<CryptoListingDataModel>> =
        getCryptoListPagingFlowUseCase.perform(Pair(sortAttributeDataModel, directionDataModel)).cachedIn(viewModelScope)

    fun setAttribute(attr: CryptoSortAttributeDataModel) {
        _sortAttribute.value = attr
    }

    fun switchDirection() {
        _sortDirection.value = if(_sortDirection.value == SortDirectionDataModel.ASC) SortDirectionDataModel.DESC
                                else SortDirectionDataModel.ASC
    }

}