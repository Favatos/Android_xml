package com.example.android_xml.feature.list.data

import com.example.android_xml.R
import com.example.android_xml.feature.list.domain.model.Car

object MockCars {
    fun returnList() : List<Car>{
        return listOf(
            Car(
                brand = "BMW",
                model = "M5",
                year = 2020,
                description = "Спортивный седан с мощным двигателем",
                cost = 5000000,
                imageResId = R.drawable.bmw
            ),
            Car(
                brand = "Audi",
                model = "A6",
                year = 2019,
                description = "Комфортный бизнес-седан",
                cost = 3500000,
                imageResId = R.drawable.audi
            ),
            Car(
                brand = "Mercedes",
                model = "E-Class",
                year = 2021,
                description = "Премиум седан с высоким уровнем комфорта",
                cost = 6000000,
                imageResId = R.drawable.mercedes
            ),
            Car(
                brand = "Toyota",
                model = "Camry",
                year = 2018,
                description = "Надежный и экономичный автомобиль",
                cost = 2500000,
                imageResId = R.drawable.toyota
            ),
            Car(
                brand = "Kia",
                model = "K5",
                year = 2022,
                description = "Современный седан с хорошим оснащением",
                cost = 2700000,
                imageResId = R.drawable.kia
            )
        )
    }
}