package com.hann.ktorclient.domain.usecase

import com.hann.ktorclient.data.Resource
import com.hann.ktorclient.data.network.response.UserResponse
import com.hann.ktorclient.domain.model.User
import com.hann.ktorclient.domain.repository.IGithubRepository
import kotlinx.coroutines.flow.Flow

class GitHubInteractor(private val iGithubRepository: IGithubRepository) : GithubUserCase {

    override  fun getSearchUser(username: String): Flow<Resource<List<User>>> {
        return iGithubRepository.getSearchUser(username)
    }

}