package com.example.android_xml.feature.calculator.domain

interface CalcRepository {
    fun calculate(expr : String) : Double
}