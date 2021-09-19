import com.douglasalipio.weathercheck.domain.Forecast
import com.douglasalipio.weathercheck.data.*
import com.douglasalipio.weathercheck.data.model.*
import com.douglasalipio.weathercheck.data.model.List


fun mockWeather() = com.douglasalipio.weathercheck.domain.Weather(
    "city",
    "country",
    "40",
    "20",
    "25",
    mutableListOf()
)

fun mockWeatherModel() =
    WeatherModel(
        "city",
        listOf(),
        Main(1f, 2f, 2),
        "11/11/2019",
        Sys("country")
    )

fun mockForecastModel() =
    _root_ide_package_.com.douglasalipio.weathercheck.data.model.ForecastModel(
        listOf(
            List(
                10L,
                "2020-02-15 21:00:00",
                Main(10f, 15f, 1),
                listOf(
                    _root_ide_package_.com.douglasalipio.weathercheck.data.model.Weather(
                        "moderate rain",
                        "iconUrl"
                    )
                )
            )
        )
    )

fun mockForecastInfo() = Forecast(
    "http://openweathermap.org/img/wn/iconUrl@2x.png",
    "10",
    "15",
    "2020-02-15 21:00:00",
    "moderate rain"
)