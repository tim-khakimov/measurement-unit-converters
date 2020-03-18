package com.timkhakimov.measurementunitconverters.domain.entity

import com.timkhakimov.measurementunitconverters.domain.data.model.MeasurementUnit

/**
 * Created by Timur Khakimov on 18.03.2020
 */
object Utils {

    fun measurementUnit(id : Int, conversionFactor : Double) : MeasurementUnit {
        return MeasurementUnit(id, "", "", "", conversionFactor)
    }
}