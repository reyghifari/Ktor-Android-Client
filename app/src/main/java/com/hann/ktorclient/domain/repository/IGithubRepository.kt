package com.hann.ktorclient.domain.repository


import com.hann.ktorclient.data.Resource
import com.hann.ktorclient.data.network.response.UserResponse

interface IGithubRepository {

    suspend fun getSearchUser(username: String): Resource<List<UserResponse>>

}