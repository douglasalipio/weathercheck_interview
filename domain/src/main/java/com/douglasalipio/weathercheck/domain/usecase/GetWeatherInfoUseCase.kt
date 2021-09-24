package com.douglasalipio.weathercheck.domain.usecase


import com.douglasalipio.weathercheck.domain.Resource
import com.douglasalipio.weathercheck.domain.entity.WeatherInfoEntity
import com.douglasalipio.weathercheck.domain.repository.WeatherRepository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.IOException
import javax.inject.Inject


class GetWeatherInfoUseCase @Inject constructor(private val weatherRepository: WeatherRepository) {

    operator fun invoke(param: Params): Flow<Resource<WeatherInfoEntity>> = flow {
        try {
            emit(Resource.Loading<WeatherInfoEntity>())
            val weatherInfo = weatherRepository.requestWeatherBy(param.city)
            emit(Resource.Success<WeatherInfoEntity>(weatherInfo))
        } catch (e: IOException) {
            emit(Resource.Error<WeatherInfoEntity>("Couldn't reach server. Check your internet Connection"))
        }

    }

    data class Params(val city: String)
}