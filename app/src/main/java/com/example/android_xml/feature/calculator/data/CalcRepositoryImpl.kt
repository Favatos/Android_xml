package com.example.android_xml.feature.calculator.data

import com.example.android_xml.feature.calculator.domain.CalcRepository
import net.objecthunter.exp4j.ExpressionBuilder

class CalcRepositoryImpl : CalcRepository {
    override fun calculate(expr: String): Double {
        return ExpressionBuilder(expr).build().evaluate()
    }
}