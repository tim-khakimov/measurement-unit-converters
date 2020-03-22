package com.timkhakimov.measurementunitconverters.di.modules.presentation

import com.timkhakimov.measurementunitconverters.di.modules.presentation.livedata.LiveDataModule
import com.timkhakimov.measurementunitconverters.di.modules.presentation.livedata.MappedListItemsLiveDataModule
import dagger.Module

/**
 * Created by Timur Khakimov on 22.03.2020
 */
@Module(
    includes = arrayOf(
        LiveDataModule::class, MappedListItemsLiveDataModule::class
    )
)
class PresentationModule {
}