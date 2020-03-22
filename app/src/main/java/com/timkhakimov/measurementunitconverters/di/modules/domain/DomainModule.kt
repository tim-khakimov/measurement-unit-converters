package com.timkhakimov.measurementunitconverters.di.modules.domain

import com.timkhakimov.measurementunitconverters.di.modules.data.DataModule
import com.timkhakimov.measurementunitconverters.domain.boundary.OutputBoundary
import com.timkhakimov.measurementunitconverters.domain.boundary.Resource
import com.timkhakimov.measurementunitconverters.domain.data.model.Quantity
import com.timkhakimov.measurementunitconverters.domain.data.source.Repository
import com.timkhakimov.measurementunitconverters.domain.data.storage.QuantitiesDataStorage
import com.timkhakimov.measurementunitconverters.domain.interactors.QuantitiesInteractor
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
}