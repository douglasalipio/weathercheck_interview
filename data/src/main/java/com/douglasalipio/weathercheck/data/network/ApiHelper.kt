package com.douglasalipio.weathercheck.data.network

import com.douglasalipio.weathercheck.data.weatherinfo.model.ForecastModel
import com.douglasalipio.weathercheck.data.weatherinfo.model.WeatherModel
import retrofit2.http.GET
import retrofit2.http.Query

private const val APP_ID = "bd8326266ffeb1b662cf75fadf5dee2a"
private const val DEFAULT_UNITS = "metric"

interface ApiHelper {

    @GET("/data/2.5/weather")
    suspend fun getWeather(
        @Query("q") city: String,
        @Query("units") units: String = DEFAULT_UNITS,
        @Query("APPID") appId: String = APP_ID
    ): WeatherModel

    @GET("data/2.5/forecast")
    suspend fun getForecast(
        @Query("q") city: String,
        @Query("units") units: String = DEFAULT_UNITS,
        @Query("APPID") appId: String = APP_ID
    ): ForecastModel
}