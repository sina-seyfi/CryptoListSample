package com.sinaseyfi.remote.models.crypto

import com.sinaseyfi.remote.ID
import com.sinaseyfi.remote.LIMIT
import com.sinaseyfi.remote.SORT
import com.sinaseyfi.remote.SORT_DIRECTION
import com.sinaseyfi.remote.START
import com.sinaseyfi.remote.base.BaseResponse
import com.sinaseyfi.remote.models.crypto.info.CryptoInfoDto
import com.sinaseyfi.remote.models.crypto.list.CryptoListingDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface CryptoEndpoint {

    @GET("listings/latest")
    suspend fun fetchList(
        @Query(START) start: Int,
        @Query(LIMIT) limit: Int,
        @Query(SORT) sort: String,
        @Query(SORT_DIRECTION) dir: String
    ): Response<BaseResponse<List<CryptoListingDto>>>

    @GET("info")
    suspend fun fetchInfo(@Query(ID) cryptoId: Long): Response<BaseResponse<CryptoInfoDto>>

}