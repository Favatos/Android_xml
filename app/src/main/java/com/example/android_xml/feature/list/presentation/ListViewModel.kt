package com.example.android_xml.feature.list.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.android_xml.feature.list.data.MockCars
import com.example.android_xml.feature.list.domain.model.Car

class ListViewModel : ViewModel() {
    private val _cars = MutableLiveData<List<Car>>()
    val cars: LiveData<List<Car>> = _cars

    init {
        loadCars()
    }

    private fun loadCars() {
        _cars.value = MockCars.returnList()
    }
}