package com.douglasalipio.weathercheck.data.remote


import com.douglasalipio.weathercheck.data.network.ApiHelper
import kotlinx.coroutines.ExperimentalCoroutinesApi

@ExperimentalCoroutinesApi
class RemoteDataSourceImp(private val apiHelper: ApiHelper) : RemoteDataSource {

    override suspend fun getWeatherBy(city: String) = apiHelper.getWeather(city)

    override suspend fun getForecastBy(city: String) = apiHelper.getForecast(city)
}