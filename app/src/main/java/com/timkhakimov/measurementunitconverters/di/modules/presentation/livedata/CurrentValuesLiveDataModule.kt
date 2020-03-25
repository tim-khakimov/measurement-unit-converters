package com.timkhakimov.measurementunitconverters.di.modules.presentation.livedata

import com.timkhakimov.measurementunitconverters.presentation.livedata.CurrentValuesLiveData
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by Timur Khakimov on 25.03.2020
 */
@Module
class CurrentValuesLiveDataModule {

    @Singleton
    @Provides
    fun getCurrentValuesLiveData(): CurrentValuesLiveData {
        return CurrentValuesLiveData()
    }
}