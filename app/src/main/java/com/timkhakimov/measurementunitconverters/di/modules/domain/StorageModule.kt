package com.timkhakimov.measurementunitconverters.di.modules.domain

import com.timkhakimov.measurementunitconverters.domain.data.storage.QuantitiesDataStorage
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by Timur Khakimov on 22.03.2020
 */
@Module
class StorageModule {

    @Singleton
    @Provides
    fun getQuantitiesDataStorage() : QuantitiesDataStorage {
        return QuantitiesDataStorage()
    }
}