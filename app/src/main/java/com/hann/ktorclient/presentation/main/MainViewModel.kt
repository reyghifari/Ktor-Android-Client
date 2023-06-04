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
import kotlinx.coroutines.launch

class MainViewModel(
    private val userCase: GithubUserCase
) : ViewModel() {

   private val _user = MutableLiveData<Resource<List<UserResponse>>>(null)
    val user : LiveData<Resource<List<UserResponse>>> = _user

    init {
        viewModelScope.launch {
            _user.value = Resource.Loading()
            _user.value = userCase.getSearchUser("reyghifari")
        }
    }


}