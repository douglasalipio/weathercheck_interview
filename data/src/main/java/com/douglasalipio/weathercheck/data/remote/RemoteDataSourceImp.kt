package com.douglasalipio.weathercheck.data.remote


import com.douglasalipio.weathercheck.data.mapper.ForecastModelToForecastMapper
import com.douglasalipio.weathercheck.data.mapper.WeatherModelToWeatherMapper
import com.douglasalipio.weathercheck.data.model.ForecastModel
import com.douglasalipio.weathercheck.data.model.WeatherModel
import com.douglasalipio.weathercheck.data.network.ApiHelper
import com.douglasalipio.weathercheck.domain.entity.Weather
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

@ExperimentalCoroutinesApi
class RemoteDataSourceImp(private val apiHelper: ApiHelper) : RemoteDataSource {

    override suspend fun getWeatherBy(city: String) = apiHelper.getWeather(city)

    override suspend fun getForecastBy(city: String) = apiHelper.getForecast(city)
}