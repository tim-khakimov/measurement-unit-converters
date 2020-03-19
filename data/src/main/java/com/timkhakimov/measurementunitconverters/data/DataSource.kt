package com.timkhakimov.measurementunitconverters.data

import com.timkhakimov.measurementunitconverters.domain.data.model.MeasurementUnit
import com.timkhakimov.measurementunitconverters.domain.data.model.Quantity
import io.reactivex.Single

/**
 * Created by Timur Khakimov on 19.03.2020
 * Интерфейс для источника данных
 */
interface DataSource {

    fun getQuantities() : Single<List<Quantity>>

    fun getUnits(quantityId : Int) : Single<List<MeasurementUnit>>
}