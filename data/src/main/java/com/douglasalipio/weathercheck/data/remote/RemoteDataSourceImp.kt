package com.douglasalipio.weathercheck.data.remote


import com.douglasalipio.weathercheck.data.network.WeatherInfoService
import kotlinx.coroutines.ExperimentalCoroutinesApi

@ExperimentalCoroutinesApi
class RemoteDataSourceImp(private val weatherInfoService: WeatherInfoService) : RemoteDataSource {

    override suspend fun getWeatherBy(city: String) = weatherInfoService.getWeather(city)

    override suspend fun getForecastBy(city: String) = weatherInfoService.getForecast(city)
}