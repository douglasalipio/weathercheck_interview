package com.douglasalipio.weathercheck.weatherforecast.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Colors
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.douglasalipio.weathercheck.R


@Composable
fun WeatherInfoHeader(country: String, city: String) {

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(45.dp)
            .padding(5.dp)
            .background(
                colorResource(id = R.color.purple_700)
            )
    ) {
        Text(
            text = "$city, $country",
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.body1,
            overflow = TextOverflow.Ellipsis,
            color = Color.White,
            modifier = Modifier.padding(5.dp)
        )
    }
}