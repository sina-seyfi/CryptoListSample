package com.sinaseyfi.domain.base

import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow

abstract class BasePagingFlowUseCase<Req, Res: DataModel> {

    abstract fun perform(request: Req): Flow<PagingData<Res>>

}