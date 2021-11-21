package com.sinaseyfi.remote.models.crypto

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.sinaseyfi.data.data_sources.remote.CryptoRemoteDataSource
import com.sinaseyfi.domain.enums.CryptoSortAttributeDataModel
import com.sinaseyfi.domain.enums.SortDirectionDataModel
import com.sinaseyfi.domain.models.crypto.info.CryptoInfoDataModel
import com.sinaseyfi.domain.models.crypto.list.CryptoListingDataModel
import com.sinaseyfi.log.Logger
import com.sinaseyfi.remote.models.crypto.list.CryptoSortAttributeRequestDtoMapper
import com.sinaseyfi.remote.models.crypto.list.SortDirectionRequestDtoMapper
import com.sinaseyfi.remote.base.BaseApiService
import com.sinaseyfi.remote.models.crypto.info.CryptoInfoDtoMapper
import com.sinaseyfi.remote.models.crypto.list.CryptoListingDtoMapper
import javax.inject.Inject

class CryptoApiService @Inject constructor(
    private val cryptoListingDtoMapper: CryptoListingDtoMapper,
    private val cryptoInfoDtoMapper: CryptoInfoDtoMapper,
    private val cryptoSortAttributeRequestDtoMapper: CryptoSortAttributeRequestDtoMapper,
    private val sortDirectionRequestDtoMapper: SortDirectionRequestDtoMapper,
    private val logger: Logger
): BaseApiService<CryptoEndpoint>(CryptoEndpoint::class.java),
    CryptoRemoteDataSource {

    override fun fetchCryptoListPage(sortAttribute: CryptoSortAttributeDataModel, sortDirectionDataModel: SortDirectionDataModel): PagingSource<Int, CryptoListingDataModel> = object: PagingSource<Int, CryptoListingDataModel>() {

        override fun getRefreshKey(state: PagingState<Int, CryptoListingDataModel>): Int? {
            return state.anchorPosition?.let { anchorPosition ->
                val anchorPage = state.closestPageToPosition(anchorPosition)
                anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
            }
        }

        override suspend fun load(params: LoadParams<Int>): LoadResult<Int, CryptoListingDataModel> {
            val position = params.key ?: CryptoRemoteDataSource.INITIAL_LOAD_SIZE
            val offset = if (params.key != null) ((position - 1) * CryptoRemoteDataSource.NETWORK_PAGE_SIZE) + 1
            else CryptoRemoteDataSource.INITIAL_LOAD_SIZE
            return try {
                val response = executionWithMessage {
                    apiService.fetchList(
                        offset,
                        params.loadSize,
                        cryptoSortAttributeRequestDtoMapper.mapToDto(sortAttribute).attr,
                        sortDirectionRequestDtoMapper.mapToDto(sortDirectionDataModel).dir
                    )
                }.data
                val list = List(response!!.data!!.size) { index ->
                    cryptoListingDtoMapper.mapToDataModel(response.data!![index])
                }
                logger.info("List is empty: ${list.isEmpty()}")
                val nextKey = if (list.isEmpty()) {
                    null
                } else {
                    // initial load size = 3 * NETWORK_PAGE_SIZE
                    // ensure we're not requesting duplicating items, at the 2nd request
                    position + (params.loadSize / CryptoRemoteDataSource.NETWORK_PAGE_SIZE)
                }
                LoadResult.Page(
                    data = list,
                    prevKey = null, // Only paging forward.
                    // assume that if a full page is not loaded, that means the end of the data
                    nextKey = nextKey
                )
            } catch (e: Exception) {
                logger.error(e)
                LoadResult.Error(e)
            }
        }

    }

    override suspend fun fetchInfo(cryptoId: Long): CryptoInfoDataModel =
        cryptoInfoDtoMapper.mapToDataModel(executionWithMessage { apiService.fetchInfo(cryptoId) }.data?.data)


}