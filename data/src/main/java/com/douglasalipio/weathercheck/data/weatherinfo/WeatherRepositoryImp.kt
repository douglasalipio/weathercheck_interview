package com.douglasalipio.weathercheck.data.weatherinfo

import com.douglasalipio.weathercheck.data.weatherinfo.mapper.ForecastModelToForecastMapper
import com.douglasalipio.weathercheck.data.weatherinfo.mapper.WeatherModelToWeatherMapper
import com.douglasalipio.weathercheck.data.remote.RemoteDataSource
import com.douglasalipio.weathercheck.domain.entity.WeatherInfoEntity
import com.douglasalipio.weathercheck.domain.repository.WeatherRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn


@ExperimentalCoroutinesApi
class WeatherRepositoryImp(
    private val remoteDataSource: RemoteDataSource,
    private val weatherMapper: WeatherModelToWeatherMapper,
    private val forecastMapper: ForecastModelToForecastMapper
) : WeatherRepository {

    override suspend fun requestWeatherBy(city: String): Flow<WeatherInfoEntity> {
        return flow {
            val weather = weatherMapper.map(remoteDataSource.getWeatherBy(city))
            val forecasts = forecastMapper.mapToList(remoteDataSource.getForecastBy(city))
            weather.forecastList.addAll(forecasts)
            emit(weather)
        }.flowOn(Dispatchers.IO)
    }

}