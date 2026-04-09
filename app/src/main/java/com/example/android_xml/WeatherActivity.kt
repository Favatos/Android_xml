package com.example.android_xml

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.android_xml.databinding.WeatherActivityBinding
import kotlinx.coroutines.launch

class WeatherActivity : AppCompatActivity(){
    lateinit var binding: WeatherActivityBinding

    private lateinit var adapter: WeatherAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = WeatherActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.toolbar.setNavigationOnClickListener { finish() }

        adapter = WeatherAdapter(emptyList())

        loadWeather()
        Log.d("weather:activity", "Weather")
        binding.recyclerWeather.layoutManager = LinearLayoutManager(this)
        binding.recyclerWeather.adapter = adapter
    }

    private fun loadWeather() {
        lifecycleScope.launch {
            try {
                val response = RetrofitClient.weatherApi.getWeatherForecast(
                    longitude = 37.6,
                    latitude = 55.7
                )

                val weatherList = response.dataseries

                adapter.updateList(weatherList)

            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}