package com.douglasalipio.weathercheck.data.model

import com.google.gson.annotations.SerializedName

data class ForecastModel(
    @SerializedName("list")
    val list: kotlin.collections.List<List>
)

data class List(
    @SerializedName("dt")
    val timestamp: Long,
    @SerializedName("dt_txt")
    val dateUtcString: String,
    @SerializedName("main")
    val main: Main,
    @SerializedName("weather")
    val weather: kotlin.collections.List<Weather>
)

data class Weather(
    @SerializedName("description")
    val description: String,
    @SerializedName("icon")
    val icon: String
)