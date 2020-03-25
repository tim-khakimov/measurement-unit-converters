package com.timkhakimov.measurementunitconverters.di.modules.presentation.livedata

import com.timkhakimov.measurementunitconverters.di.modules.presentation.MappersModule
import com.timkhakimov.measurementunitconverters.domain.data.model.MeasurementUnit
import com.timkhakimov.measurementunitconverters.domain.data.model.Quantity
import com.timkhakimov.measurementunitconverters.presentation.livedata.MeasurementUnitValuesLiveData
import com.timkhakimov.measurementunitconverters.presentation.livedata.QuantityListItemsLiveData
import com.timkhakimov.measurementunitconverters.presentation.mappers.Mapper
import com.timkhakimov.measurementunitconverters.presentation.mappers.ResourceListMapper
import com.timkhakimov.measurementunitconverters.presentation.model.MeasurementUnitValue
import com.timkhakimov.measurementunitconverters.presentation.model.QuantityListItem
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by Timur Khakimov on 22.03.2020
 */
@Module(includes = arrayOf(MappersModule::class))
class MappedListItemsLiveDataModule {

    @Singleton
    @Provides
    fun getQuantityListItemsLiveData(mapper: Mapper<Quantity, QuantityListItem>): QuantityListItemsLiveData {
        return QuantityListItemsLiveData(ResourceListMapper(mapper))
    }

    @Singleton
    @Provides
    fun getMeasurementUnitValuesLiveData(mapper: Mapper<MeasurementUnit, MeasurementUnitValue>): MeasurementUnitValuesLiveData {
        return MeasurementUnitValuesLiveData(ResourceListMapper(mapper))
    }
}