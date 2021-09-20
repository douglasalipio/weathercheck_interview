package com.douglasalipio.weathercheck.data.model

import com.douglasalipio.weathercheck.data.model.WeatherModelToWeatherMapper
import mockWeather
import mockWeatherModel
import org.junit.Assert.assertEquals
import org.junit.Test

class WeatherModelToWeatherMapperTest {

    private val mapper = WeatherModelToWeatherMapper()

    @Test
    fun `should validate weather mapper`() {
        // given
        val weatherDto = mockWeather()
        val expectedWeatherInfo = mockWeather()
        // when
        val mappingResult = mapper.map(mockWeatherModel())
        // then
        assertEquals(expectedWeatherInfo.city, mappingResult.city)
    }
}
