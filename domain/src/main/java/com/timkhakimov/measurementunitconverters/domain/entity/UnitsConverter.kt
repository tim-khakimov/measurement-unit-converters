package com.timkhakimov.measurementunitconverters.domain.entity

import com.timkhakimov.measurementunitconverters.domain.data.model.MeasurementUnit
import com.timkhakimov.measurementunitconverters.domain.data.storage.MeasurementUnitsDataStorage

/**
 * Created by Timur Khakimov on 18.03.2020
 * Конвертирует значение по введенной ед-це измерения во все остальные ед-цы измерения этой же физической величины
 * Т.е. передаем значение 1 метр -> возвращает соответствующие значения для футов, дюймов и т.д.
 * Если другие ед-цы измерения не найдены, возвращает только введенные данные
 */
class UnitsConverter(private val measurementUnitsData : MeasurementUnitsDataStorage) {

    private val unitValuesConverter = UnitValuesConverter()

    fun convertUnitValue(unitId: Int, value : Double) : MutableMap<Int, Double> {
        val unitsValuesMap = mutableMapOf<Int, Double>()
        unitsValuesMap[unitId] = value
        val inputUnit = measurementUnitsData.getItem(unitId) ?: return unitsValuesMap
        fillUnitsValues(unitsValuesMap, measurementUnitsData.getOtherUnits(unitId), unitValuesConverter.convertToBaseValue(inputUnit, value))
        return unitsValuesMap
    }

    private fun fillUnitsValues(unitsValuesMap : MutableMap<Int, Double>, units : Collection<MeasurementUnit>, baseUnitsValue : Double) {
        for (unit in units) {
            unitsValuesMap[unit.id] = unitValuesConverter.convertFromBaseValue(unit, baseUnitsValue)
        }
    }
}