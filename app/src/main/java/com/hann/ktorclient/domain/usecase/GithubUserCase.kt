package com.hann.ktorclient.domain.usecase

import com.hann.ktorclient.data.network.ApiResponse
import com.hann.ktorclient.data.network.response.UserResponse

interface GithubUserCase {

    suspend fun getSearchUser(username: String): ApiResponse<List<UserResponse>>

}