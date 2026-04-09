package com.example.android_xml

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.android_xml.databinding.ListActivityBinding

class ListActivity : AppCompatActivity() {

    lateinit var binding : ListActivityBinding
    private lateinit var adapter: CarAdapter
    private lateinit var allCars: List<Car>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ListActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        allCars = listOf(
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
        adapter = CarAdapter(allCars)

        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = adapter

        binding.toolbar.setNavigationOnClickListener { finish() }
    }
}