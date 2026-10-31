package com.example.movie2you.data.api

import com.example.movie2you.BuildConfig
import okhttp3.Interceptor
import okhttp3.Response
import java.io.IOException

class ApiKeyInterceptor: Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val originalRequest = chain.request()
        if (BuildConfig.API_KEY.isBlank()) {
            throw IOException("TMDB API key is not configured.")
        }
        if (originalRequest.url.scheme != "https" ||
            originalRequest.url.host != "api.themoviedb.org") {
            throw IOException("Refusing to send credentials to an unexpected endpoint.")
        }
        val newUrl = originalRequest.url
            .newBuilder()
            .addQueryParameter("api_key", BuildConfig.API_KEY)
            .build()
        val newRequest = originalRequest
            .newBuilder()
            .url(newUrl)
            .build()
        return chain.proceed(newRequest)
    }
}
