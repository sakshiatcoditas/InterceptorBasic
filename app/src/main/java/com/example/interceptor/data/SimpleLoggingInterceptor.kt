package com.example.interceptor.data

import okhttp3.Interceptor
import okhttp3.Response

class SimpleLoggingInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        // Get the original request
        val request = chain.request()

        // Create a new request with custom headers
        val newRequest = request.newBuilder()
            .addHeader("Authorization", "Bearer YOUR_TOKEN")
            .addHeader("Accept", "application/json")
            .build()

        // Record start time
        val startTime = System.currentTimeMillis()

        // Proceed with the modified request
        val response = chain.proceed(newRequest)

        // Record end time
        val endTime = System.currentTimeMillis()

        // Log request details
        println(" Request: ${newRequest.method} ${newRequest.url}")
        // Log response details
        println(" Response: ${response.code} in ${endTime - startTime}ms")

        // Return the server's response
        return response
    }
}