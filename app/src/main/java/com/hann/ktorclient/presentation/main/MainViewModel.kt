package com.hann.ktorclient.presentation.main

import androidx.lifecycle.ViewModel
import com.hann.ktorclient.domain.usecase.GithubUserCase

class MainViewModel(
    private val userCase: GithubUserCase
) : ViewModel() {
}