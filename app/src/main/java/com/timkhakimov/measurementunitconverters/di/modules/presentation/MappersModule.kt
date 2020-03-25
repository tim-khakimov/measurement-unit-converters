package com.timkhakimov.measurementunitconverters.di.modules.presentation

import com.timkhakimov.measurementunitconverters.domain.data.model.MeasurementUnit
import com.timkhakimov.measurementunitconverters.domain.data.model.Quantity
import com.timkhakimov.measurementunitconverters.presentation.mappers.Mapper
import com.timkhakimov.measurementunitconverters.presentation.model.MeasurementUnitValue
import com.timkhakimov.measurementunitconverters.presentation.model.QuantityListItem
import dagger.Module
import dagger.Provides

/**
 * Created by Timur Khakimov on 22.03.2020
 */
@Module
class MappersModule {

    @Provides
    fun getQuantityMapper(): Mapper<Quantity, QuantityListItem> {
        return object : Mapper<Quantity, QuantityListItem> {
            override fun map(inputData: Quantity): QuantityListItem {
                return QuantityListItem(inputData)
            }
        }
    }

    @Provides
    fun getMeasurementUnitMapper(): Mapper<MeasurementUnit, MeasurementUnitValue> {
        return object : Mapper<MeasurementUnit, MeasurementUnitValue> {
            override fun map(inputData: MeasurementUnit): MeasurementUnitValue {
                return MeasurementUnitValue(inputData)
            }
        }
    }
}