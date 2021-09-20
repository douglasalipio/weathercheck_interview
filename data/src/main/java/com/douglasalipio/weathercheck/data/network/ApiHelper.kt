package com.douglasalipio.weathercheck.data.network

import com.douglasalipio.weathercheck.data.model.ForecastModel
import com.douglasalipio.weathercheck.data.model.WeatherModel
import retrofit2.http.GET
import retrofit2.http.Query

const val BASE_URL = " https://jsonplaceholder.typicode.com/"
private const val APP_ID = "bd8326266ffeb1b662cf75fadf5dee2a"

interface ApiHelper {

    @GET("/data/2.5/weather")
    suspend fun getWeather(
        @Query("q") city: String,
        @Query("units") units: String = "metric",
        @Query("APPID") appId: String = APP_ID
    ): WeatherModel

    @GET("data/2.5/forecast")
    suspend fun getForecast(
        @Query("q") city: String,
        @Query("units") units: String = "metric",
        @Query("APPID") appId: String = APP_ID
    ): ForecastModel
}