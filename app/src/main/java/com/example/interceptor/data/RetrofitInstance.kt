package com.example.interceptor.data

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    private const val BASE_URL = "https://brasilapi.com.br/"

    val apiService: BrasilApiService by lazy {

        val client = OkHttpClient.Builder()
            .addInterceptor(SimpleLoggingInterceptor())
            .build()

        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(BrasilApiService::class.java)
    }
}
