package com.example.android_xml.feature.calculator.presentation

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.android_xml.databinding.CalculatorActivityBinding

class CalculatorActivity : AppCompatActivity() {
    private val viewModel : CalculatorViewModel by viewModels()
    lateinit var binding: CalculatorActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = CalculatorActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.toolbar.setNavigationOnClickListener { finish() }

        viewModel.display.observe(this) {
            binding.textResult.text = it
        }

        listOf(
            binding.btnOne to "1",
            binding.btnTwo to "2",
            binding.btnThree to "3",
            binding.btnFour to "4",
            binding.btnFive to "5",
            binding.btnSix to "6",
            binding.btnSeven to "7",
            binding.btnEight to "8",
            binding.btnNine to "9",
            binding.btnZero to "0"
        ).forEach { (view, value) ->
            view.setOnClickListener {
                viewModel.appendDigit(value)
            }
        }

        listOf(
            binding.btnPlus to "+",
            binding.btnMinus to "-",
            binding.btnMultiply to "*",
            binding.btnDivide to "/"
        ).forEach { (view, value) ->
            view.setOnClickListener {
                viewModel.appendOperator(value)
            }
        }

        binding.btnC.setOnClickListener {
            viewModel.clear()
        }

        binding.btnEquals.setOnClickListener {
            viewModel.calculate()
        }
    }
}