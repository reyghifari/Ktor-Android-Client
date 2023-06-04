package com.hann.ktorclient.data.network.response


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class UserResponse(
    @SerialName("avatar_url")
    val avatarUrl: String,
    @SerialName("id")
    val id: Int,
    @SerialName("login")
    val login: String,
)