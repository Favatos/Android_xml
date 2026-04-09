package com.example.android_xml

data class WeatherResponse(
    val product: String,
    val init: String,
    val dataseries: List<DataSeries>
)

data class DataSeries(
    val date: String,
    val weather: String,
    val temp2m: Temp2m,
    val wind10m_max: Int?
)

data class Temp2m(
    val min : Int,
    val max : Int
)