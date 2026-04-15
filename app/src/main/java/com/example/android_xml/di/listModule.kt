package com.example.android_xml.di

import com.example.android_xml.feature.list.presentation.ListViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val listModule = module {
    viewModel { ListViewModel() }
}