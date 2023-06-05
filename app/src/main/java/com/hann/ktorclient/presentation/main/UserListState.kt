package com.hann.ktorclient.presentation.main

import com.hann.ktorclient.domain.model.User

data class UserListState (
    val isLoading : Boolean = false,
    val users: List<User> = emptyList(),
    val error: String = ""
)