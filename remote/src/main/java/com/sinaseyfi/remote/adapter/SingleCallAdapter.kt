package com.sinaseyfi.remote.adapter

import com.sinaseyfi.remote.base.ResponseWrapper
import retrofit2.Response

class SingleCallAdapter<T>(
    private val apiCall: suspend () -> Response<T>
) :
    CallAdapter<ResponseWrapper<T>> {
    override suspend fun execute(): ResponseWrapper<T> {
        try {
            val execute = apiCall.invoke()
            if (execute.isSuccessful) {
                val response = execute.body()
                return if(response == null) {
                    ResponseWrapper.Complete()
                } else {
                    ResponseWrapper.Success(response)
                }
            } else {
//                if (execute.code() == HttpURLConnection.HTTP_FORBIDDEN || execute.code() == HttpURLConnection.HTTP_UNAUTHORIZED) {
//                    throw AuthorizationException()
//                }

//                try {
//                    val errorBody = execute.errorBody()?.string()
//                    val messageResponse = Gson().fromJson(errorBody, MessageResponse::class.java)
//                    val flags = ErrorResponseFlagFactory.create(messageResponse)
//                    throw NetworkException(messageResponse.message, execute.code().toString(), messageResponse.errors, flags)
//                } catch (e: NetworkException) {
//                    throw e
//                } catch (e: Exception) {
//                    throw NetworkException(null, execute.code().toString())
//                }

                throw Exception()


            }

        } catch (exception: Exception) {
            return ResponseWrapper.Error(exception)
        }
    }
}