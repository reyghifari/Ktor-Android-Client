package com.hann.ktorclient.domain.usecase

import com.hann.ktorclient.data.network.ApiResponse
import com.hann.ktorclient.data.network.response.UserResponse
import com.hann.ktorclient.domain.repository.IGithubRepository

class GitHubInteractor(private val iGithubRepository: IGithubRepository) : GithubUserCase {

    override suspend fun getSearchUser(username: String): ApiResponse<List<UserResponse>> {
        return iGithubRepository.getSearchUser(username)
    }

}