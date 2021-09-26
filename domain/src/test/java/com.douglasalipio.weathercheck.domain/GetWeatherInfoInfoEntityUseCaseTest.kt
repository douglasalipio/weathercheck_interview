package com.douglasalipio.weathercheck.domain

import com.douglasalipio.weathercheck.domain.entity.WeatherInfoEntity
import com.douglasalipio.weathercheck.domain.repository.WeatherRepository
import com.douglasalipio.weathercheck.domain.usecase.GetWeatherInfoUseCase
import com.nhaarman.mockitokotlin2.given
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Test
import org.mockito.ArgumentMatchers.anyString
import org.mockito.Mock
import org.mockito.MockitoAnnotations.initMocks

class GetWeatherInfoInfoEntityUseCaseTest {

    @Mock
    private lateinit var weatherRepositoryMock: WeatherRepository
    private lateinit var getWeatherInfoUseCase: GetWeatherInfoUseCase

    @Before
    fun setUp() {
        initMocks(this)
        getWeatherInfoUseCase = GetWeatherInfoUseCase(weatherRepositoryMock)
    }

    @Test
    fun `should retrieve weather forecast data`() = runBlocking {

        //given
        val weatherFlow = mockWeather()
        val params = GetWeatherInfoUseCase.Params("Recife")
        given(weatherRepositoryMock.requestWeatherBy(anyString())).willReturn(weatherFlow)

        //when
        val weatherFlowActual = getWeatherInfoUseCase.invoke(params).first()

        //Then
        assertNotNull(weatherFlowActual)
    }

    private fun mockWeather() = WeatherInfoEntity(
        city = "city",
        country = "country",
        humidity = "40",
        temperature = "20",
        feelsLike = "25",
        forecastList = mutableListOf()
    )

}