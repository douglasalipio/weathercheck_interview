package com.douglasalipio.weathercheck.weatherforecast.mapper

import com.douglasalipio.weathercheck.domain.entity.Forecast

class WeatherInfoPresentation(
    val city: String,
    val country: String,
    val humidity: String,
    val temperature: String,
    val feelsLike: String,
    var forecastList: MutableList<Forecast> = mutableListOf()
)