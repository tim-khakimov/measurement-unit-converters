package com.timkhakimov.measurementunitconverters.di.modules.data

import com.timkhakimov.measurementunitconverters.data.DataRepository
import com.timkhakimov.measurementunitconverters.data.DataSource
import com.timkhakimov.measurementunitconverters.domain.data.source.Repository
import dagger.Module
import dagger.Provides

/**
 * Created by Timur Khakimov on 22.03.2020
 */
@Module(includes = arrayOf(DataSourceModule::class))
class DataModule {

    @Provides
    fun getRepository(dataSource: DataSource) : Repository {
        val repository = DataRepository()
        repository.dataSource = dataSource
        return repository
    }
}