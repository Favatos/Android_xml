package com.example.android_xml.feature.home

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.android_xml.feature.calculator.presentation.CalculatorActivity
import com.example.android_xml.feature.list.presentation.ListActivity
import com.example.android_xml.feature.weather.presentation.WeatherActivity
import com.example.android_xml.databinding.HomeActivityBinding

class HomeActivity : AppCompatActivity() {

    lateinit var binding: HomeActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = HomeActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.weather.setOnClickListener {
            val intent = Intent(this, WeatherActivity::class.java)
            startActivity(intent)
        }
        binding.listButton.setOnClickListener {
            val intent = Intent(this, ListActivity::class.java)
            startActivity(intent)
        }
        binding.calculator.setOnClickListener {
            val intent = Intent(this, CalculatorActivity::class.java)
            startActivity(intent)
        }

        binding.toolbar.setNavigationOnClickListener { finish() }
    }
}