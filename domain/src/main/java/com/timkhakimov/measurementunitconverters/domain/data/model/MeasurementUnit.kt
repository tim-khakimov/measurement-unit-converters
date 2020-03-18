package com.timkhakimov.measurementunitconverters.domain.data.model

/**
 * Created by Timur Khakimov on 18.03.2020
 * Единица измерения
 */
data class MeasurementUnit(
    val id: Int,
    val unitSymbol: String,
    val name: String,
    val description: String,
    val conversionFactor: Double        //должно быть > 0, если 1.0 - базовая ед-ца измерения
)