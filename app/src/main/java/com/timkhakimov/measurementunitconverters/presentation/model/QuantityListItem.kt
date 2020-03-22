package com.timkhakimov.measurementunitconverters.presentation.model

import com.timkhakimov.measurementunitconverters.domain.data.model.Quantity

/**
 * Created by Timur Khakimov on 22.03.2020
 * Модель presentation слоя для физической величины
 */
data class QuantityListItem(val quantity: Quantity) {

    fun getTitle() : String {
        return quantity.name
    }
}