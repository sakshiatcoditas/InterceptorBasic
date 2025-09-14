
package com.example.interceptor.data
import retrofit2.http.GET


interface BrasilApiService {
    @GET("api/feriados/v1/2024")
    suspend fun getHolidays(): List<Holiday>
}
