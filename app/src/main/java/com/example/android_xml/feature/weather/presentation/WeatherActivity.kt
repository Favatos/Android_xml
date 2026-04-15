package com.example.android_xml.feature.weather.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.android_xml.databinding.WeatherActivityBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class WeatherActivity : AppCompatActivity() {

    private lateinit var binding: WeatherActivityBinding
    private lateinit var adapter: WeatherAdapter
    private val viewModel: WeatherViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = WeatherActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.toolbar.setNavigationOnClickListener { finish() }

        adapter = WeatherAdapter(emptyList())

        binding.recyclerWeather.layoutManager = LinearLayoutManager(this)
        binding.recyclerWeather.adapter = adapter

        viewModel.weatherList.observe(this) {
            adapter.updateList(it)
        }

        viewModel.loadWeather()
    }
}