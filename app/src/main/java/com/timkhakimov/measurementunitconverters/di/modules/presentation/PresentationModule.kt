package com.timkhakimov.measurementunitconverters.di.modules.presentation

import com.timkhakimov.measurementunitconverters.di.modules.presentation.livedata.LiveDataModule
import com.timkhakimov.measurementunitconverters.di.modules.presentation.livedata.MappedListItemsLiveDataModule
import com.timkhakimov.measurementunitconverters.di.modules.presentation.livedata.SelectedItemsLiveDataModule
import dagger.Module

/**
 * Created by Timur Khakimov on 22.03.2020
 */
@Module(
    includes = arrayOf(
        LiveDataModule::class, MappedListItemsLiveDataModule::class, SelectedItemsLiveDataModule::class
    )
)
class PresentationModule {
}