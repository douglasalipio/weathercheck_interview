package com.douglasalipio.weathercheck.weatherforecast

import com.douglasalipio.weathercheck.weatherforecast.mapper.WeatherInfoPresentation

data class WeatherInfoState(
    val isLoading: Boolean = false,
    val error: String = "",
    val weatherInfo: WeatherInfoPresentation? = null
)