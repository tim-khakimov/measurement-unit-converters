package com.timkhakimov.measurementunitconverters.di.modules.domain

import com.timkhakimov.measurementunitconverters.di.modules.data.DataModule
import com.timkhakimov.measurementunitconverters.domain.boundary.OutputBoundary
import com.timkhakimov.measurementunitconverters.domain.boundary.Resource
import com.timkhakimov.measurementunitconverters.domain.data.model.MeasurementUnit
import com.timkhakimov.measurementunitconverters.domain.data.model.Quantity
import com.timkhakimov.measurementunitconverters.domain.data.source.Repository
import com.timkhakimov.measurementunitconverters.domain.data.storage.MeasurementUnitsDataStorage
import com.timkhakimov.measurementunitconverters.domain.data.storage.QuantitiesDataStorage
import com.timkhakimov.measurementunitconverters.domain.entity.UnitsConverter
import com.timkhakimov.measurementunitconverters.domain.interactors.MeasurementUnitsInteractor
import com.timkhakimov.measurementunitconverters.domain.interactors.QuantitiesInteractor
import com.timkhakimov.measurementunitconverters.domain.interactors.UnitValuesInteractor
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by Timur Khakimov on 22.03.2020
 */
@Module(
    includes = arrayOf(
        DataModule::class,
        StorageModule::class,
        OutputBoundariesModule::class
    )
)
class DomainModule {

    @Singleton
    @Provides
    fun getQuantitiesInteractor(
        repository: Repository,
        quantitiesOutputBoundary: OutputBoundary<Resource<List<Quantity>>>,
        quantitiesDataStorage: QuantitiesDataStorage
    ): QuantitiesInteractor {
        val interactor = QuantitiesInteractor()
        interactor.repository = repository
        interactor.quantitiesOutputBoundary = quantitiesOutputBoundary
        interactor.quantitiesDataStorage = quantitiesDataStorage
        return interactor
    }

    @Singleton
    @Provides
    fun getMeasurementUnitsInteractor(
        repository: Repository,
        unitsOutputBoundary: OutputBoundary<Resource<List<MeasurementUnit>>>,
        measurementUnitsDataStorage: MeasurementUnitsDataStorage
    ): MeasurementUnitsInteractor {
        val interactor = MeasurementUnitsInteractor()
        interactor.repository = repository
        interactor.unitsOutputBoundary = unitsOutputBoundary
        interactor.measurementUnitsDataStorage = measurementUnitsDataStorage
        return interactor
    }

    @Provides
    fun getUnitValuesInteractor(
        unitValuesOutputBoundary: OutputBoundary<Map<Int, Double>>,
        measurementUnitsDataStorage: MeasurementUnitsDataStorage
    ): UnitValuesInteractor {
        val interactor = UnitValuesInteractor()
        interactor.unitValuesOutputBoundary = unitValuesOutputBoundary
        interactor.unitsConverter = UnitsConverter(measurementUnitsDataStorage)
        return interactor
    }
}