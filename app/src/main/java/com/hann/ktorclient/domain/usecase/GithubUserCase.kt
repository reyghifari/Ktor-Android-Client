package com.hann.ktorclient.domain.usecase

import com.hann.ktorclient.data.Resource
import com.hann.ktorclient.data.network.response.UserResponse
import com.hann.ktorclient.domain.model.User
import kotlinx.coroutines.flow.Flow

interface GithubUserCase {

    fun getSearchUser(username: String): Flow<Resource<List<User>>>

}