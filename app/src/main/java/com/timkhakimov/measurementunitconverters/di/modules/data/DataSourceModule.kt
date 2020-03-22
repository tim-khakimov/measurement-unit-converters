package com.timkhakimov.measurementunitconverters.di.modules.data

import com.timkhakimov.measurementunitconverters.data.DataSource
import com.timkhakimov.measurementunitconverters.data.hardcode.HardcodeDataSource
import dagger.Module
import dagger.Provides

/**
 * Created by Timur Khakimov on 22.03.2020
 */
@Module
class DataSourceModule {

    @Provides
    fun getDataSource() : DataSource {
        return HardcodeDataSource()
    }
}