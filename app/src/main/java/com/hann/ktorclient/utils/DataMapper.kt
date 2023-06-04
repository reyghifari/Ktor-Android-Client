package com.hann.ktorclient.utils

import com.hann.ktorclient.data.network.response.UserResponse
import com.hann.ktorclient.domain.model.User

object DataMapper {

    fun mapResponsesToDomain(input: List<UserResponse>): List<User> {
        val userList = ArrayList<User>()
        input.map {
            val user = User(
                id = it.id,
                login = it.login,
                avatar_url = it.avatarUrl
            )
            userList.add(user)
        }
        return userList
    }

}