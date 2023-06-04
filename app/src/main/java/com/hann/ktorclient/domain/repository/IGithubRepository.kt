package com.hann.ktorclient.domain.repository


import com.hann.ktorclient.data.network.ApiResponse
import com.hann.ktorclient.data.network.response.UserResponse

interface IGithubRepository {

    suspend fun getSearchUser(username: String): ApiResponse<List<UserResponse>>

}