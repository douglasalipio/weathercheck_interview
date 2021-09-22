package com.douglasalipio.weathercheck.weatherforecast

import com.douglasalipio.weathercheck.domain.entity.WeatherInfoEntity

sealed class WeatherInfoState {
    object Error : WeatherInfoState()
    object Loading : WeatherInfoState()
    data class Data(val weatherInfoEntity : WeatherInfoEntity) : WeatherInfoState()
}