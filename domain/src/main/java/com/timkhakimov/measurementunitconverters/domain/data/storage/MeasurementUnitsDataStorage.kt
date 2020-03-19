package com.timkhakimov.measurementunitconverters.domain.data.storage

import com.timkhakimov.measurementunitconverters.domain.data.model.MeasurementUnit

/**
 * Created by Timur Khakimov on 18.03.2020
 * Единицы измерения
 */
open class MeasurementUnitsDataStorage : DataStorage<MeasurementUnit>() {

    open fun setMeasurementUnits(units: Collection<MeasurementUnit>) {
        setItems(units) { it.id }
    }

    fun getOtherUnits(unitId: Int): Collection<MeasurementUnit> {
        return itemsMap.values.filter { it.id != unitId }
    }
}