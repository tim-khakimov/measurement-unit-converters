package com.timkhakimov.measurementunitconverters.presentation.handlers

import com.timkhakimov.measurementunitconverters.presentation.model.MeasurementUnitValue

/**
 * Created by Timur Khakimov on 25.03.2020
 * Интерфейс для обработки введенного пользователем значения по единице измерения
 */
interface EditedUnitValueHandler {
    fun handleEditedValue(measurementUnitValue: MeasurementUnitValue, editedString: String)
}