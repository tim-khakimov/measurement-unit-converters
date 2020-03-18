package com.timkhakimov.measurementunitconverters.domain.entity

import com.timkhakimov.measurementunitconverters.domain.data.model.MeasurementUnit

/**
 * Created by Timur Khakimov on 18.03.2020
 * Конвертация ед-ц измерения в базовые и обратно
 */
class UnitValuesConverter {

    fun convertToBaseValue(unit: MeasurementUnit, unitValue: Double): Double {
        return unit.conversionFactor * unitValue
    }

    fun convertFromBaseValue(unit: MeasurementUnit, baseUnitsValue: Double): Double {
        return when (unit.conversionFactor) {
            0.0 -> 0.0
            else -> baseUnitsValue / unit.conversionFactor
        }
    }
}