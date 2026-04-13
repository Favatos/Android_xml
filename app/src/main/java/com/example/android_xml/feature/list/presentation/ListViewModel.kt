package com.example.android_xml.feature.list.presentation

import androidx.lifecycle.ViewModel
import com.example.android_xml.feature.list.data.MockCars
import com.example.android_xml.feature.list.domain.model.Car

class ListViewModel : ViewModel() {
    var allCars: List<Car> = MockCars.returnList()
}