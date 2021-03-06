package com.douglasalipio.weathercheck.weatherforecast

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.douglasalipio.weathercheck.weatherforecast.component.WeatherInfoHeader
import com.douglasalipio.weathercheck.weatherforecast.component.WeatherInfoItem

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun WeatherForecastScreen(viewModel: WeatherInfoViewModel = hiltViewModel()) {
    val state = viewModel.state.value
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        LazyColumn(modifier = Modifier.fillMaxSize()) {
            val forecasts = state.weatherInfo?.forecastList ?: emptyList()
            stickyHeader {
                WeatherInfoHeader(
                    country = state.weatherInfo?.country ?: "",
                    city = state.weatherInfo?.city ?: ""
                )
            }
            items(forecasts) {
                WeatherInfoItem(forecast = it)
            }
        }
        if (state.error.isNotBlank()) {
            Text(
                text = state.error,
                color = MaterialTheme.colors.error,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
                    .align(Alignment.Center)
            )
        }
        if (state.isLoading) {
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        }
    }
}