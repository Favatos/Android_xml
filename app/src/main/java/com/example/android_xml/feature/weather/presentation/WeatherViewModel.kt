package com.example.android_xml.feature.weather.presentation

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.android_xml.feature.weather.data.DataSeries
import com.example.android_xml.feature.weather.data.RetrofitClient
import kotlinx.coroutines.launch

class WeatherViewModel(
    private val retrofit: RetrofitClient
) : ViewModel() {
    private val _weatherList = MutableLiveData<List<DataSeries>>()
    val weatherList: LiveData<List<DataSeries>> = _weatherList

    fun loadWeather() {
        viewModelScope.launch {
            try {
                val response = retrofit.weatherApi.getWeatherForecast(
                    longitude = 37.6,
                    latitude = 55.7
                )

                _weatherList.value = response.dataseries

            } catch (e: Exception) {
                Log.d("weather:activity", e.message.toString())
                _weatherList.value = emptyList()
            }
        }
    }
}