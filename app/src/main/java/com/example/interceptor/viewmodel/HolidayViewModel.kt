package com.example.interceptor.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.interceptor.data.Holiday
import com.example.interceptor.data.HolidayRepository
import com.example.interceptor.data.RetrofitInstance
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class HolidayViewModel(
    private val repository: HolidayRepository = HolidayRepository(RetrofitInstance.apiService)
) : ViewModel() {

    private val _holidays = MutableStateFlow<List<Holiday>>(emptyList())
    val holidays: StateFlow<List<Holiday>> = _holidays

    init {
        viewModelScope.launch {
            _holidays.value = try {
                repository.fetchHolidays()
            } catch (e: Exception) {
                emptyList()
            }
        }
    }
}
