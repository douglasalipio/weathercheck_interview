package com.douglasalipio.weathercheck.data

import com.douglasalipio.weathercheck.domain.entity.Forecast
import com.douglasalipio.weathercheck.domain.entity.Weather
import kotlinx.coroutines.flow.Flow

interface WeatherRepository {

    suspend fun requestWeatherBy(city: String): Flow<Weather>

}