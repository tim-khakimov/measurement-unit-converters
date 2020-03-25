package com.timkhakimov.measurementunitconverters.presentation.handlers

import com.timkhakimov.measurementunitconverters.domain.interactors.UnitValuesInteractor
import com.timkhakimov.measurementunitconverters.presentation.model.MeasurementUnitValue
import java.lang.NumberFormatException

/**
 * Created by Timur Khakimov on 25.03.2020
 * Реализация EditedUnitValueHandler
 */
class MainEditUnitValueHandler(private val unitValuesInteractor: UnitValuesInteractor) : EditedUnitValueHandler {

    override fun handleEditedValue(measurementUnitValue: MeasurementUnitValue, editedString: String) {
        if(editedString == measurementUnitValue.getCurrentValue()) {
            return
        }
        try {
            checkValue(measurementUnitValue, editedString.replace(',', '.').toDouble())
        } catch (e : NumberFormatException){

        }
    }

    private fun checkValue(unitValue: MeasurementUnitValue, editedValue : Double) {
        if(unitValue.value != editedValue) {
            unitValue.value = editedValue
            unitValuesInteractor.setMeasurementUnitValue(unitValue.measurementUnit.id, editedValue)
        }
    }
}