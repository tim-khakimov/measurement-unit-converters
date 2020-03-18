package com.timkhakimov.measurementunitconverters.domain.data.storage

import com.timkhakimov.measurementunitconverters.domain.data.model.Quantity

/**
 * Created by Timur Khakimov on 18.03.2020
 * Физические величины
 */
class QuantitiesDataStorage : DataStorage<Quantity>() {

    fun setQuantities(units: Collection<Quantity>) {
        setItems(units) { it.id }
    }
}