package com.hann.ktorclient.domain.usecase

import com.hann.ktorclient.data.Resource
import com.hann.ktorclient.data.network.response.UserResponse
import com.hann.ktorclient.domain.repository.IGithubRepository

class GitHubInteractor(private val iGithubRepository: IGithubRepository) : GithubUserCase {

    override suspend fun getSearchUser(username: String): Resource<List<UserResponse>> {
        return iGithubRepository.getSearchUser(username)
    }

}