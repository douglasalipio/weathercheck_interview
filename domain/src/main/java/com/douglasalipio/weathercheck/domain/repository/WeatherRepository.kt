package com.douglasalipio.weathercheck.domain.repository

import com.douglasalipio.weathercheck.domain.entity.WeatherInfoEntity
import kotlinx.coroutines.flow.Flow

interface WeatherRepository {

    suspend fun requestWeatherBy(city: String): WeatherInfoEntity

}