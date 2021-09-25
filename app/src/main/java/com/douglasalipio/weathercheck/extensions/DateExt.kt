package com.douglasalipio.weathercheck.extensions

import org.threeten.bp.LocalDate
import org.threeten.bp.format.DateTimeFormatter

private const val OUTPUT_FORMAT = "EEE, d MMM"
private const val UTC_DATE_FORMAT = "yyyy-MM-dd HH:mm:ss"

fun String.toDateFormat(): String {
    val localDate =
        LocalDate.parse(this, DateTimeFormatter.ofPattern(UTC_DATE_FORMAT))
    return localDate.format(DateTimeFormatter.ofPattern(OUTPUT_FORMAT))
}