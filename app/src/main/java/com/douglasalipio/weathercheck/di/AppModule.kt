package com.douglasalipio.weathercheck.di

import com.douglasalipio.weathercheck.domain.repository.WeatherRepository
import com.douglasalipio.weathercheck.domain.usecase.GetWeatherInfoUseCase
import com.douglasalipio.weathercheck.weatherforecast.mapper.WeatherInfoPresentationMapper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun provideMapperWeatherInfoPresentation(): WeatherInfoPresentationMapper {
        return WeatherInfoPresentationMapper()
    }

    @Singleton
    fun provideGetWeatherInfoUseCase(weatherRepository: WeatherRepository): GetWeatherInfoUseCase {
        return GetWeatherInfoUseCase(weatherRepository)
    }
}