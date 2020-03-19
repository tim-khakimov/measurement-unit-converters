package com.timkhakimov.measurementunitconverters.data.hardcode

import com.timkhakimov.measurementunitconverters.domain.data.model.MeasurementUnit

/**
 * Created by Timur Khakimov on 19.03.2020
 */
class UnitsBuilder {

    private val list = mutableListOf<MeasurementUnit>()

    fun add(id : Int, unitSymbol: String, name: String, conversionFactor: Double) : UnitsBuilder {
        list.add(MeasurementUnit(id, unitSymbol, name, "", conversionFactor))
        return this
    }

    fun build() : List<MeasurementUnit> {
        return list
    }
}