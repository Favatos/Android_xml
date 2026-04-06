package com.example.android_xml

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.android_xml.databinding.CalculatorActivityBinding

class CalculatorActivity : AppCompatActivity() {
    lateinit var binding: CalculatorActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = CalculatorActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.toolbar.setNavigationOnClickListener { finish() }
    }
}