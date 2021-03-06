package com.timkhakimov.measurementunitconverters.di.modules.domain

import com.timkhakimov.measurementunitconverters.di.modules.presentation.livedata.MappedListItemsLiveDataModule
import com.timkhakimov.measurementunitconverters.domain.boundary.OutputBoundary
import com.timkhakimov.measurementunitconverters.domain.boundary.Resource
import com.timkhakimov.measurementunitconverters.domain.data.model.MeasurementUnit
import com.timkhakimov.measurementunitconverters.domain.data.model.Quantity
import com.timkhakimov.measurementunitconverters.presentation.livedata.CurrentValuesLiveData
import com.timkhakimov.measurementunitconverters.presentation.livedata.MeasurementUnitValuesLiveData
import com.timkhakimov.measurementunitconverters.presentation.livedata.QuantityListItemsLiveData
import dagger.Module
import dagger.Provides

/**
 * Created by Timur Khakimov on 22.03.2020
 */
@Module(includes = arrayOf(MappedListItemsLiveDataModule::class))
class OutputBoundariesModule {

    @Provides
    fun getQuantitiesBoundary(quantityListItemsLiveData: QuantityListItemsLiveData): OutputBoundary<Resource<List<Quantity>>> {
        return quantityListItemsLiveData
    }

    @Provides
    fun getMeasurementUnitsBoundary(measurementUnitValuesLiveData: MeasurementUnitValuesLiveData): OutputBoundary<Resource<List<MeasurementUnit>>> {
        return measurementUnitValuesLiveData
    }

    @Provides
    fun getUnitValuesOutputBoundary(currentValuesLiveData: CurrentValuesLiveData): OutputBoundary<Map<Int, Double>> {
        return currentValuesLiveData
    }
}