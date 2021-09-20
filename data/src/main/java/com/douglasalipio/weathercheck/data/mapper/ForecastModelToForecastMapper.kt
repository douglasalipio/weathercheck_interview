package com.douglasalipio.weathercheck.data.mapper

import com.douglasalipio.weathercheck.domain.entity.Forecast
import com.douglasalipio.weathercheck.data.model.ForecastModel
import kotlin.collections.List

class ForecastModelToForecastMapper : Mapper<ForecastModel, Forecast> {

    override fun mapToList(from: ForecastModel): List<Forecast> {
        val forecastList = mutableListOf<Forecast>()
        from.list.forEach {
            forecastList.add(
                Forecast(
                    iconUrl = "http://openweathermap.org/img/wn/${it.weather.last().icon}@2x.png",
                    description = it.weather.last().description,
                    date = it.dateUtcString,
                    feelsLike = it.main.feelsLike.toInt().toString(),
                    temperature = it.main.temp.toInt().toString()
                )
            )
        }
        return forecastList
    }

    override fun map(from: ForecastModel): Forecast {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}