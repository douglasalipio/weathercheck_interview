package com.douglasalipio.weathercheck.data.model

import com.google.gson.annotations.SerializedName
import kotlin.collections.List

data class WeatherModel(
    @SerializedName("name")
    val name: String,
    val forecasts: List<ForecastModel>,
    @SerializedName("main")
    val main: Main,
    @SerializedName("dt")
    val date: String,
    @SerializedName("sys")
    val countryInfo: Sys
)


data class Main(
    @SerializedName("temp")
    val temp: Float,
    @SerializedName("feels_like")
    val feelsLike: Float,
    @SerializedName("humidity")
    val humidity: Int
)

data class Sys(
    @SerializedName("country")
    val country: String
)