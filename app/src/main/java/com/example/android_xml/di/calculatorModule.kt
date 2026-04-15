package com.example.android_xml.di

import com.example.android_xml.feature.calculator.data.CalcRepositoryImpl
import com.example.android_xml.feature.calculator.domain.CalcRepository
import com.example.android_xml.feature.calculator.presentation.CalculatorViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val calculatorModule = module {
    single<CalcRepository> { CalcRepositoryImpl() }

    viewModel {
        CalculatorViewModel(get())
    }
}