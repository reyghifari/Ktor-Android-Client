package com.hann.ktorclient.data

import android.util.Log
import com.hann.ktorclient.utils.Constants
import io.ktor.client.*
import io.ktor.client.engine.android.*
import io.ktor.client.features.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import io.ktor.client.features.logging.*
import io.ktor.client.features.observer.*
import io.ktor.client.request.*
import io.ktor.http.*

class GithubHttpClient() {

    fun getHttpClient() = HttpClient(Android){
        install(JsonFeature){
            serializer = KotlinxSerializer(kotlinx.serialization.json.Json {
                prettyPrint = true
                isLenient = true
                ignoreUnknownKeys = true
            })
        }

        install(Logging){
            logger = object : Logger {
                override fun log(message: String) {
                    Log.i(TAG_HTTP_STATUS_LOGGER, message)
                }
            }
        }

        install(ResponseObserver){
            onResponse {
                Log.i(TAG_HTTP_STATUS_LOGGER, "${it.status.value}")
            }
        }

        install(DefaultRequest){
            header(HttpHeaders.ContentType, ContentType.Application.Json)
            parameter("api_key", Constants.BASE_URL)
        }

        engine {
            connectTimeout = TIME_OUT
            socketTimeout = TIME_OUT
        }
    }

    companion object {
        private const val TIME_OUT = 10_000
        private const val TAG_KTOR_LOGGER = "ktor_logger:"
        private const val TAG_HTTP_STATUS_LOGGER = "http_status:"
    }



}