package com.douglasalipio.weathercheck.data

import com.douglasalipio.weathercheck.data.mapper.ForecastModelToForecastMapper
import com.douglasalipio.weathercheck.data.mapper.WeatherModelToWeatherMapper
import com.douglasalipio.weathercheck.data.remote.RemoteDataSource
import com.nhaarman.mockitokotlin2.given
import junit.framework.Assert.assertEquals
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.single
import kotlinx.coroutines.runBlocking
import mockForecastModel
import mockWeatherModel
import org.junit.Before
import org.junit.Test
import org.mockito.ArgumentMatchers.anyString
import org.mockito.Mock
import org.mockito.MockitoAnnotations.initMocks

@ExperimentalCoroutinesApi
class WeatherRepositoryTest {

    @Mock
    private lateinit var remoteDataSourceMock: RemoteDataSource
    private lateinit var weatherRepository: WeatherRepository
    private val forecastMapper = ForecastModelToForecastMapper()
    private val weatherMapper = WeatherModelToWeatherMapper()


    @Before
    fun setup() {
        initMocks(this)
        weatherRepository =
            WeatherRepositoryImp(remoteDataSourceMock, weatherMapper, forecastMapper)

    }

    @Test
    fun `should request weather from repository`() = runBlocking {
        //Given
        given(remoteDataSourceMock.getWeatherBy(anyString())).willReturn(mockWeatherModel())
        given(remoteDataSourceMock.getForecastBy(anyString())).willReturn(mockForecastModel())

        //When
        val weatherActual = weatherRepository.requestWeatherBy("Recife").first()

        //Then
        assertEquals(mockWeatherModel().name, weatherActual.city)
    }
}