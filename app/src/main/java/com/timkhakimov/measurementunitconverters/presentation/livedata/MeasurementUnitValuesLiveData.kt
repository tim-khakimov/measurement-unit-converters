package com.timkhakimov.measurementunitconverters.presentation.livedata

import com.timkhakimov.measurementunitconverters.domain.data.model.MeasurementUnit
import com.timkhakimov.measurementunitconverters.presentation.mappers.ResourceListMapper
import com.timkhakimov.measurementunitconverters.presentation.model.MeasurementUnitValue

/**
 * Created by Timur Khakimov on 25.03.2020
 * LiveData для хранения элементов MeasurementUnitValue
 */
class MeasurementUnitValuesLiveData(resourceListMapper:
    ResourceListMapper<MeasurementUnit, MeasurementUnitValue>) : MappedListItemsLiveData<MeasurementUnit, MeasurementUnitValue>(resourceListMapper) {

    fun updateValues(unitValuesMap : Map<Int, Double>) {
        value?.data?.let { updateValues(it, unitValuesMap) }
    }

    private fun updateValues(list : List<MeasurementUnitValue>, unitValuesMap : Map<Int, Double>) {
        for (unitValue in list) {
            unitValue.updateValue(unitValuesMap)
        }
    }
}