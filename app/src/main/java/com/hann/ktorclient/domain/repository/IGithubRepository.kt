package com.hann.ktorclient.domain.repository


import com.hann.ktorclient.data.Resource
import com.hann.ktorclient.domain.model.User
import kotlinx.coroutines.flow.Flow

interface IGithubRepository {

    fun getSearchUser(username: String): Flow<Resource<List<User>>>

}