package com.douglasalipio.weathercheck.domain

import com.douglasalipio.weathercheck.domain.entity.WeatherInfoEntity
import com.douglasalipio.weathercheck.domain.repository.WeatherRepository
import com.douglasalipio.weathercheck.domain.usecase.GetWeatherInfoUseCase
import com.nhaarman.mockitokotlin2.given
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.single
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
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
        val weatherFlowExpected = flowOf(mockWeather())
        val params = GetWeatherInfoUseCase.Params("Recife")
        given(weatherRepositoryMock.requestWeatherBy(anyString())).willReturn(weatherFlowExpected)
        //when
        val weatherFlowActual = getWeatherInfoUseCase.execute(params).single()
        //Then
        assertEquals(weatherFlowExpected.first(), weatherFlowActual)
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