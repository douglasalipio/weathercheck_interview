package com.douglasalipio.weathercheck.data.mapper

import com.douglasalipio.weathercheck.data.mapper.ForecastModelToForecastMapper
import mockForecastInfo
import mockForecastModel
import org.junit.Assert.assertEquals
import org.junit.Test

class ForecastModelToForecastMapperTest {

    private val mapper = ForecastModelToForecastMapper()

    @Test
    fun `should validate forecast mapper`() {
        // given
        val forecastDto = mockForecastModel()
        val expectedForecastInfo = mockForecastInfo()
        // when
        val mappingResult = mapper.mapToList(forecastDto)
        // then
        assertEquals(expectedForecastInfo.iconUrl, mappingResult.last().iconUrl)
    }
}
