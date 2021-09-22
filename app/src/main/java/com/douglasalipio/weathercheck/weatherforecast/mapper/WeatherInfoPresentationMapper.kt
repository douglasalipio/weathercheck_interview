package com.douglasalipio.weathercheck.weatherforecast.mapper

import com.douglasalipio.weathercheck.domain.Mapper
import com.douglasalipio.weathercheck.domain.entity.WeatherInfoEntity

class WeatherInfoPresentationMapper : Mapper<WeatherInfoEntity, WeatherInfoPresentation> {

    override fun map(from: WeatherInfoEntity) = WeatherInfoPresentation(
        city = from.city,
        country = from.country,
        humidity = from.humidity,
        temperature = from.temperature,
        forecastList = from.forecastList,
        feelsLike = from.feelsLike
    )


    override fun mapToList(from: WeatherInfoEntity): List<WeatherInfoPresentation> {
        TODO("Not yet implemented")
    }
}
