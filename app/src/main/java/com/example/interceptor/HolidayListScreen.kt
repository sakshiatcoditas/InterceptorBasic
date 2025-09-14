package com.example.interceptor.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.interceptor.data.Holiday
import com.example.interceptor.viewmodel.HolidayViewModel

@Composable
fun HolidayListScreen(viewModel: HolidayViewModel = androidx.lifecycle.viewmodel.compose.viewModel()) {
    val holidays by viewModel.holidays.collectAsState()

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        items(holidays) { holiday ->
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
            ) {
                Text(text = holiday.date, style = MaterialTheme.typography.labelSmall)
                Text(text = holiday.name, style = MaterialTheme.typography.titleMedium)
                Text(text = holiday.type, style = MaterialTheme.typography.bodySmall)
            }
            HorizontalDivider()
        }
    }
}
