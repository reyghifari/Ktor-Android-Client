package com.hann.ktorclient

import android.app.Application
import com.hann.ktorclient.di.httpClientModule
import com.hann.ktorclient.di.repositoryModule
import com.hann.ktorclient.di.useCaseModule
import com.hann.ktorclient.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext
import org.koin.core.logger.Level

class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        GlobalContext.startKoin {
            androidLogger(Level.NONE)
            androidContext(this@MyApplication)
            modules(
                listOf(
                    httpClientModule,
                    repositoryModule,
                    useCaseModule,
                    viewModelModule
                )
            )
        }
    }

}