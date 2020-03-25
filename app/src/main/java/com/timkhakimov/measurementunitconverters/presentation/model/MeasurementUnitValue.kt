package com.timkhakimov.measurementunitconverters.presentation.model

import androidx.databinding.BaseObservable
import com.timkhakimov.measurementunitconverters.domain.data.model.MeasurementUnit
import java.text.DecimalFormat

/**
 * Created by Timur Khakimov on 25.03.2020
 * Модель presentation слоя для единицы измерения и её значения
 */
class MeasurementUnitValue(val measurementUnit: MeasurementUnit) : BaseObservable() {

    var value : Double = 0.0

    fun getTitle() : String {
        return String.format("%s, %s", measurementUnit.name, measurementUnit.unitSymbol)
    }

    fun getCurrentValue() : String {
        return DecimalFormat("#.######").format(value)
    }

    fun updateValue(unitValuesMap: Map<Int, Double>) {
        unitValuesMap.get(measurementUnit.id)?.let { updateValue(it) }
    }

    private fun updateValue(updatedValue: Double) {
        if(value != updatedValue) {
            value = updatedValue
            notifyChange()
        }
    }
}