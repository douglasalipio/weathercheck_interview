package com.douglasalipio.weathercheck.data.remote

import com.douglasalipio.weathercheck.data.weatherinfo.model.ForecastModel
import com.douglasalipio.weathercheck.data.weatherinfo.model.WeatherModel

interface RemoteDataSource {

    suspend fun getWeatherBy(city: String): WeatherModel

    suspend fun getForecastBy(city: String): ForecastModel
}