package com.douglasalipio.weathercheck.weatherforecast.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.douglasalipio.weathercheck.domain.entity.Forecast
import com.douglasalipio.weathercheck.extensions.toDateFormat
import com.skydoves.landscapist.glide.GlideImage


@Composable
fun WeatherInfoItem(
    forecast: Forecast
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(12.dp)
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .padding(5.dp)
            ) {
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = forecast.date.toDateFormat(),
                    style = MaterialTheme.typography.body1,
                    overflow = TextOverflow.Ellipsis,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = forecast.description,
                    textAlign = TextAlign.End,
                    style = MaterialTheme.typography.body2,
                )
            }

            Column(
                horizontalAlignment = Alignment.End
            ) {
                GlideImage(
                    imageModel = forecast.iconUrl,
                    modifier = Modifier
                        .width(42.dp)
                        .height(42.dp)
                )

                Text(
                    text = "${forecast.temperature}°",
                    textAlign = TextAlign.End,
                    style = MaterialTheme.typography.body2,
                )
                Text(
                    color = Color.Gray,
                    text = "${forecast.feelsLike}°",
                    fontStyle = FontStyle.Italic,
                    textAlign = TextAlign.End,
                    style = MaterialTheme.typography.body2,
                )
            }
        }
    }
}