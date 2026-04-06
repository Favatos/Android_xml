package com.example.android_xml

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.android_xml.databinding.WeatherActivityBinding

class WeatherActivity : AppCompatActivity(){
    lateinit var binding: WeatherActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = WeatherActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.toolbar.setNavigationOnClickListener { finish() }
    }
}