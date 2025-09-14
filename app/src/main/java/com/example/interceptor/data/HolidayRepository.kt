package com.example.interceptor.data

class HolidayRepository(private val api: BrasilApiService) {
    suspend fun fetchHolidays(): List<Holiday> = api.getHolidays()
}
