package com.example.android_xml.feature.calculator.presentation

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.android_xml.feature.calculator.data.CalcRepositoryImpl

class CalculatorViewModel : ViewModel() {

    // текущее выражение (логика)
    private var currentExpression: String = "0"
    private val repository = CalcRepositoryImpl()

    // то, что отображается на экране
    private val _display = MutableLiveData("0")
    val display: LiveData<String> = _display

    fun appendDigit(digit: String) {
        if (currentExpression == "0") {
            currentExpression = digit
        } else {
            currentExpression += digit
        }

        _display.value = currentExpression
    }

    fun appendOperator(operator: String) {
        if (currentExpression.isEmpty()) return

        val lastChar = currentExpression.last()

        if (lastChar in "+-*/") return

        currentExpression += operator
        _display.value = currentExpression
    }

    fun clear() {
        currentExpression = "0"
        _display.value = "0"
    }

    fun calculate() {
        try {
            val lastChar = currentExpression.last()

            if (lastChar in "+-*/") return

            val result = repository.calculate(currentExpression)

            val resultText = if (result % 1 == 0.0) {
                result.toInt().toString()
            } else {
                result.toString()
            }

            currentExpression = resultText
            _display.value = resultText

        } catch (e: Exception) {
            _display.value = "Error"
            currentExpression = "0"
            Log.d("calc:vm", e.message.toString())
        }
    }
}