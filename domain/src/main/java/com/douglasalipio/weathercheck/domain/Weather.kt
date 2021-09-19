package com.douglasalipio.weathercheck.domain

class Weather(
    val city: String,
    val country: String,
    val humidity: String,
    val temperature: String,
    val feelsLike: String,
    var forecastList: MutableList<Forecast> = mutableListOf()
)