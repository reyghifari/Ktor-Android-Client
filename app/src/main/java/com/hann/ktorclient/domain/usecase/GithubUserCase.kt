package com.hann.ktorclient.domain.usecase

import com.hann.ktorclient.data.Resource
import com.hann.ktorclient.data.network.response.UserResponse

interface GithubUserCase {

    suspend fun getSearchUser(username: String): Resource<List<UserResponse>>

}