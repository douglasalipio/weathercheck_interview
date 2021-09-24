package com.douglasalipio.weathercheck.weatherforecast

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.douglasalipio.weathercheck.ui.theme.WeatherCheckTheme
import com.douglasalipio.weathercheck.weatherforecast.mapper.WeatherInfoPresentation
import dagger.hilt.android.AndroidEntryPoint
import org.koin.androidx.viewmodel.compat.ViewModelCompat.getViewModel
import org.koin.androidx.viewmodel.compat.ViewModelCompat.viewModel

@AndroidEntryPoint
class WeatherInfoActivity : ComponentActivity() {

    private val viewModel: WeatherInfoViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel.fetchWeatherForecast("Recife")

        setContent() {
            WeatherCheckTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    WeatherForecastScreen()
                }
            }
        }
    }
}

@Composable
fun WeatherForecastScreen() {
}


@Composable
fun WeatherForecastItem(weatherInfo: WeatherInfoPresentation) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = "${weatherInfo.city}",
            style = MaterialTheme.typography.body1,
            overflow = TextOverflow.Ellipsis
        )
    }
}


@Composable
fun WeatherForecastContent() {
    LazyColumn {

        // Add a single item
        item {
            Text(text = "First item")
        }
        // Add 5 items
        items(5) { index ->
            Text(text = "Item: $index")
        }

        // Add another single item
        item {
            Text(text = "Last item")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    WeatherCheckTheme {
        WeatherForecastContent()
    }
}