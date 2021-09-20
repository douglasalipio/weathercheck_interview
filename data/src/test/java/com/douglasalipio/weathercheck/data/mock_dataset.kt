import com.douglasalipio.weathercheck.domain.entity.Forecast
import com.douglasalipio.weathercheck.data.model.*
import com.douglasalipio.weathercheck.data.model.List
import com.douglasalipio.weathercheck.domain.entity.Weather


fun mockWeather() = Weather(
    city = "city",
    country = "country",
    humidity = "40",
    temperature = "20",
    feelsLike = "25",
    forecastList = mutableListOf()
)

fun mockWeatherModel() =
    WeatherModel(
        name = "city",
        forecasts = listOf(mockForecastModel()),
        main = Main(temp = 1f, feelsLike = 2f, humidity = 2),
        date = "11/11/2019",
        countryInfo = Sys(country = "country")
    )

fun mockForecastModel() =
    ForecastModel(
        list = listOf(
            List(
                timestamp = 10L,
                dateUtcString = "2020-02-15 21:00:00",
                main = Main(10f, 15f, 1),
                weather = listOf(
                    Weather(
                        description = "moderate rain",
                        icon = "iconUrl"
                    )
                )
            )
        )
    )

fun mockForecastInfo() = Forecast(
    iconUrl = "http://openweathermap.org/img/wn/iconUrl@2x.png",
    temperature = "10",
    feelsLike = "15",
    date = "2020-02-15 21:00:00",
    description = "moderate rain"
)