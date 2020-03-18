package com.timkhakimov.measurementunitconverters.domain.data.storage

import com.timkhakimov.measurementunitconverters.domain.data.model.MeasurementUnit

/**
 * Created by Timur Khakimov on 18.03.2020
 * Единицы измерения
 */
class MeasurementUnitsDataStorage : DataStorage<MeasurementUnit>() {

    fun setMeasurementUnits(units: Collection<MeasurementUnit>) {
        setItems(units) { it.id }
    }
}