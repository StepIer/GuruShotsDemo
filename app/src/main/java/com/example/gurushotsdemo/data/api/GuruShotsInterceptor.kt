package com.example.gurushotsdemo.data.api

import com.example.gurushotsdemo.data.Config
import okhttp3.Interceptor
import okhttp3.Response

class GuruShotsInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        return chain.proceed(
            chain.request().newBuilder().apply {
                Config.MAP_HEADERS.forEach {
                    addHeader(it.key, it.value)
                }
            }.build()
        )
    }
}