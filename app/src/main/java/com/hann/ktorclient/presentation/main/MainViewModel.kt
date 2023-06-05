package com.hann.ktorclient.presentation.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hann.ktorclient.data.Resource
import com.hann.ktorclient.data.network.ApiResponse
import com.hann.ktorclient.data.network.response.UserResponse
import com.hann.ktorclient.domain.model.User
import com.hann.ktorclient.domain.usecase.GithubUserCase
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch

class MainViewModel(
    private val userCase: GithubUserCase
) : ViewModel() {

    private val _state = MutableLiveData<UserListState>()
    val state : LiveData<UserListState> = _state

    init {
        getUsers("hann")
    }

    fun getUsers(username: String){
        userCase.getSearchUser(username).onEach {
                result ->
            when(result){
                is Resource.Loading -> {
                    _state.value = UserListState(isLoading = true)
                }
                is Resource.Error -> {
                    _state.value = UserListState(error = result.message ?: "An unexpected Error occured")
                }
                is Resource.Success -> {
                    _state.value = UserListState(users = result.data ?: emptyList())
                }

            }
        }.launchIn(viewModelScope)
    }


}