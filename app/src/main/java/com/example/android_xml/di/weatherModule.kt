package com.example.android_xml.di

import com.example.android_xml.feature.weather.data.RetrofitClient
import com.example.android_xml.feature.weather.presentation.WeatherViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val weatherModule = module {
    single { RetrofitClient }

    viewModel {
        WeatherViewModel(get())
    }
}