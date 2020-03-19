package com.timkhakimov.measurementunitconverters.domain.entity

import com.timkhakimov.measurementunitconverters.domain.data.model.MeasurementUnit
import com.timkhakimov.measurementunitconverters.domain.data.model.Quantity
import org.mockito.Mockito

/**
 * Created by Timur Khakimov on 18.03.2020
 */
object Utils {

    fun measurementUnit(id : Int, conversionFactor : Double) : MeasurementUnit {
        return MeasurementUnit(id, "", "", "", conversionFactor)
    }

    fun quantity(id : Int) : Quantity {
        return Quantity(id, "")
    }

    /**
     * Returns Mockito.any() as nullable type to avoid java.lang.IllegalStateException when
     * null is returned.
     */
    fun <T> anyNonNull(): T = Mockito.any<T>()
}