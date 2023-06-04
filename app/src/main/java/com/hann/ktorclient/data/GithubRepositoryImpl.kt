package com.hann.ktorclient.data

import com.hann.ktorclient.data.network.ApiResponse
import com.hann.ktorclient.data.network.response.SearchResponse
import com.hann.ktorclient.data.network.response.UserResponse
import com.hann.ktorclient.domain.repository.IGithubRepository
import com.hann.ktorclient.utils.Constants
import io.ktor.client.*
import io.ktor.client.request.*


class GithubRepositoryImpl(
    private val httpClient: HttpClient
) : IGithubRepository {

    override suspend fun getSearchUser(username: String): ApiResponse<List<UserResponse>> {
        return try {
            ApiResponse.Success(
                httpClient.get<SearchResponse> {
                    url(Constants.SEARCH_USER_URL.replace("{Query}", username))
                }.items
            )
        } catch (e: Exception){
            e.printStackTrace()
            ApiResponse.Error(e)
        }
    }


}