package com.douglasalipio.weathercheck.data.weatherinfo.mapper


import com.douglasalipio.weathercheck.domain.entity.WeatherInfoEntity
import com.douglasalipio.weathercheck.data.weatherinfo.model.WeatherModel
import com.douglasalipio.weathercheck.domain.Mapper
import kotlin.collections.List

class WeatherModelToWeatherMapper : Mapper<WeatherModel, WeatherInfoEntity> {

    override fun map(from: WeatherModel) = WeatherInfoEntity(
        city = from.name,
        country = from.countryInfo.country,
        humidity = from.main.humidity.toString(),
        feelsLike = from.main.feelsLike.toString(),
        temperature = from.main.temp.toString()
    )

    override fun mapToList(from: WeatherModel): List<WeatherInfoEntity> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}