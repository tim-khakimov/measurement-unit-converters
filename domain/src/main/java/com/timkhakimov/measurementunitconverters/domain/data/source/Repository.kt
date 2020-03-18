package com.timkhakimov.measurementunitconverters.domain.data.source

import com.timkhakimov.measurementunitconverters.domain.data.model.MeasurementUnit
import com.timkhakimov.measurementunitconverters.domain.data.model.Quantity

/**
 * Created by Timur Khakimov on 18.03.2020
 * Интерфейс для получения данных
 */
interface Repository {

    fun getQuantities(callback: (Response<List<Quantity>>) -> Unit)

    fun getUnits(quantityId: Int, callback: (Response<List<MeasurementUnit>>) -> Unit)
}