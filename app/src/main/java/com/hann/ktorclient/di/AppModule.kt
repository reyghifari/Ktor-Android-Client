package com.hann.ktorclient.di

import com.hann.ktorclient.data.GithubHttpClient
import com.hann.ktorclient.data.GithubRepositoryImpl
import com.hann.ktorclient.domain.repository.IGithubRepository
import com.hann.ktorclient.domain.usecase.GitHubInteractor
import com.hann.ktorclient.domain.usecase.GithubUserCase
import com.hann.ktorclient.presentation.main.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val httpClientModule = module {
    single { GithubHttpClient().getHttpClient() }
}

val repositoryModule = module {
    single<IGithubRepository> { GithubRepositoryImpl(get()) }
}

val useCaseModule = module {
    factory<GithubUserCase> {
        GitHubInteractor(get())
    }
}

val viewModelModule = module {
    viewModel {
        MainViewModel(get())
    }
}


