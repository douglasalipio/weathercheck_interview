package com.douglasalipio.weathercheck.data.di

import com.douglasalipio.weathercheck.data.network.WeatherInfoService
import com.douglasalipio.weathercheck.data.remote.RemoteDataSource
import com.douglasalipio.weathercheck.data.remote.RemoteDataSourceImp
import com.douglasalipio.weathercheck.data.weatherinfo.WeatherRepositoryImp
import com.douglasalipio.weathercheck.data.weatherinfo.mapper.ForecastModelToForecastMapper
import com.douglasalipio.weathercheck.data.weatherinfo.mapper.WeatherModelToWeatherMapper
import com.douglasalipio.weathercheck.domain.repository.WeatherRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    private const val BASE_URL = "http://api.openweathermap.org"

    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(makeLoggingInterceptor())
            .build()
    }

    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideWeatherInfoService(retrofit: Retrofit): WeatherInfoService {
        return retrofit.create(WeatherInfoService::class.java)
    }

    @Provides
    @Singleton
    fun provideWeatherInfoRemoteSource(weatherInfoService: WeatherInfoService): RemoteDataSource {
        return RemoteDataSourceImp(weatherInfoService)
    }

    @Provides
    @Singleton
    fun provideWeatherInfoRepository(
        remoteDataSource: RemoteDataSource
    ): WeatherRepository {
        return WeatherRepositoryImp(
            remoteDataSource,
            WeatherModelToWeatherMapper(),
            ForecastModelToForecastMapper()
        )
    }

    private fun makeLoggingInterceptor(isDebug: Boolean = true): HttpLoggingInterceptor {
        val logging = HttpLoggingInterceptor()
        logging.level = if (isDebug)
            HttpLoggingInterceptor.Level.BODY
        else
            HttpLoggingInterceptor.Level.NONE
        return logging
    }

}