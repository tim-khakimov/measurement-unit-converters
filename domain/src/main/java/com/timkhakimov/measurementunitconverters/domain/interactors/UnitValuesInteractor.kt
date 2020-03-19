package com.timkhakimov.measurementunitconverters.domain.interactors

import com.timkhakimov.measurementunitconverters.domain.boundary.OutputBoundary
import com.timkhakimov.measurementunitconverters.domain.entity.UnitsConverter

/**
 * Created by Timur Khakimov on 19.03.2020
 * Интерактор для конвертации значений ед-ц измерения
 * Получает значение по одной единице измерения и отправляет во внешние слои значения для всех остальных ед-ц измерния по этой же физической величине
 */
class UnitValuesInteractor {

    lateinit var unitValuesOutputBoundary: OutputBoundary<Map<Int, Double>>
    lateinit var unitsConverter: UnitsConverter

    fun setMeasurementUnitValue(unitId: Int, value: Double) {
        unitValuesOutputBoundary.sendData(unitsConverter.convertUnitValue(unitId, value))
    }
}