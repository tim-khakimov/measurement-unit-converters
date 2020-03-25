package com.timkhakimov.measurementunitconverters.di.modules.presentation.livedata

import androidx.lifecycle.MutableLiveData
import com.timkhakimov.measurementunitconverters.presentation.model.QuantityListItem
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by Timur Khakimov on 25.03.2020
 */
@Module
class SelectedItemsLiveDataModule {

    @Singleton
    @Provides
    fun getSelectedQuantityListItemLiveData(): MutableLiveData<QuantityListItem> {
        return MutableLiveData()
    }
}