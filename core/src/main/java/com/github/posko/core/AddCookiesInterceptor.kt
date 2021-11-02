package com.github.posko.core

import java.io.IOException

import okhttp3.Interceptor
import okhttp3.Response

class AddCookiesInterceptor(private val cookie : String) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val builder = chain.request().newBuilder()
        builder.addHeader("Cookie", cookie)
        return chain.proceed(builder.build())
    }

    companion object {
        private const val COOKIE = "Cookie"
    }
}