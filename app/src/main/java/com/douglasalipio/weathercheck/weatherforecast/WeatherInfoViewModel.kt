package com.douglasalipio.weathercheck.weatherforecast

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData


import com.douglasalipio.weathercheck.domain.usecase.GetWeatherInfoUseCase

class WeatherInfoViewModel(private val getWeatherInfoUseCase: GetWeatherInfoUseCase) : ViewModel() {

    var weatherInfoStream: MutableLiveData<WeatherInfoState> = MutableLiveData()

    fun fetchWeatherForecast(city: String) = liveData {
        emit(getWeatherInfoUseCase.execute(GetWeatherInfoUseCase.Params(city)))
    }

}