package com.douglasalipio.weathercheck.data.mapper


import com.douglasalipio.weathercheck.domain.entity.Weather
import com.douglasalipio.weathercheck.data.model.WeatherModel
import kotlin.collections.List

class WeatherModelToWeatherMapper : Mapper<WeatherModel, Weather> {

    override fun map(from: WeatherModel) = Weather(
        city = from.name,
        country = from.countryInfo.country,
        humidity = from.main.humidity.toString(),
        feelsLike = from.main.feelsLike.toString(),
        temperature = from.main.temp.toString()
    )

    override fun mapToList(from: WeatherModel): List<Weather> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}