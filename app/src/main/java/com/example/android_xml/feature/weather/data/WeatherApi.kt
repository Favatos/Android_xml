package com.example.android_xml.feature.weather.data

import retrofit2.http.*

interface WeatherApi {
    @GET("bin/api.pl")
    suspend fun getWeatherForecast(
        @Query("lon") longitude: Double,
        @Query("lat") latitude: Double,
        @Query("product") product: String = "civillight",
        @Query("output") output: String = "json"
    ): WeatherResponse
}