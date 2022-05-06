package com.meeweel.movieapp.data.network

import com.meeweel.movieapp.BuildConfig
import okhttp3.Interceptor
import okhttp3.Response
import java.io.IOException

class BaseInterceptor private constructor() : Interceptor {

    private var responseCode: Int = 0

    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        val response = chain.proceed(
            chain.request().newBuilder()
                .addHeader(HOST, HOST_VALUE)
                .addHeader(KEY, BuildConfig.API_KEY).build()
        )
        responseCode = response.code
        return response
    }

    fun getResponseCode(): ServerResponseStatusCode {
        var statusCode = ServerResponseStatusCode.UNDEFINED_ERROR
        when (responseCode / 100) {
            1 -> statusCode = ServerResponseStatusCode.INFO
            2 -> statusCode = ServerResponseStatusCode.SUCCESS
            3 -> statusCode = ServerResponseStatusCode.REDIRECTION
            4 -> statusCode = ServerResponseStatusCode.CLIENT_ERROR
            5 -> statusCode = ServerResponseStatusCode.SERVER_ERROR
        }
        return statusCode
    }


    enum class ServerResponseStatusCode {
        INFO,
        SUCCESS,
        REDIRECTION,
        CLIENT_ERROR,
        SERVER_ERROR,
        UNDEFINED_ERROR
    }

    companion object {
        const val HOST = "X-RapidAPI-Host"
        const val HOST_VALUE = "movies-app1.p.rapidapi.com"
        const val KEY = "X-RapidAPI-Key"
        val interceptor: BaseInterceptor
            get() = BaseInterceptor()
    }
}