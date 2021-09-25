package com.douglasalipio.weathercheck.weatherforecast

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.douglasalipio.weathercheck.domain.Resource
import com.douglasalipio.weathercheck.domain.entity.WeatherInfoEntity


import com.douglasalipio.weathercheck.domain.usecase.GetWeatherInfoUseCase
import com.douglasalipio.weathercheck.weatherforecast.mapper.WeatherInfoPresentationMapper
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WeatherInfoViewModel @Inject constructor(
    private val getWeatherInfoUseCase: GetWeatherInfoUseCase,
    private val mapper: WeatherInfoPresentationMapper
) : ViewModel() {

    private val _state = mutableStateOf(WeatherInfoState())
    val state: State<WeatherInfoState> = _state

    fun fetchWeatherForecast(city: String) {

        getWeatherInfoUseCase(GetWeatherInfoUseCase.Params("Recife")).onEach { result ->
            when (result) {
                is Resource.Success<WeatherInfoEntity> -> {
                    _state.value = WeatherInfoState(weatherInfo = mapper.map(result.data!!))
                }
                is Resource.Error<WeatherInfoEntity> -> {
                    _state.value = WeatherInfoState(
                        error = result.message ?: "An unexpected error occurred"
                    )
                }
                is Resource.Loading<WeatherInfoEntity> -> {
                    _state.value = WeatherInfoState(isLoading = true)
                }
            }

        }.launchIn(viewModelScope)
    }
}