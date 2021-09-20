package com.douglasalipio.weathercheck.domain.usecase

import com.douglasalipio.weathercheck.domain.UseCaseWithParam
import com.douglasalipio.weathercheck.domain.entity.Weather
import com.douglasalipio.weathercheck.domain.repository.WeatherRepository
import kotlinx.coroutines.flow.Flow

class GetWeatherInfoUseCase(private val weatherRepository: WeatherRepository) :
    UseCaseWithParam<Flow<Weather>, GetWeatherInfoUseCase.Params> {

    override suspend fun execute(param: Params) = weatherRepository.requestWeatherBy(param.city)

    data class Params(val city: String)
}