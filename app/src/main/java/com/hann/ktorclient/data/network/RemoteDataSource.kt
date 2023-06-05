package com.hann.ktorclient.data.network

import com.hann.ktorclient.data.network.response.SearchResponse
import com.hann.ktorclient.data.network.response.UserResponse
import com.hann.ktorclient.utils.Constants
import io.ktor.client.*
import io.ktor.client.request.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class RemoteDataSource constructor(private val httpClient: HttpClient) {

    suspend fun getSearchUser(username: String) : Flow<ApiResponse<List<UserResponse>>> {
        return flow {
            try {
                val response = httpClient.get<SearchResponse> {
                        url(Constants.SEARCH_USER_URL.replace("{Query}", username))
                    }.items
                if (response.isNotEmpty()){
                    emit(ApiResponse.Success(response))
                }else{
                    emit(ApiResponse.Empty)
                }
            }catch (e: Exception){
                emit(ApiResponse.Error(e.toString()))
            }
        }.flowOn(Dispatchers.IO)
    }

}