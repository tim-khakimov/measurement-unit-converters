package com.timkhakimov.measurementunitconverters.presentation.viewmodel

import com.timkhakimov.measurementunitconverters.MeasurementUnitConvertersApplication
import com.timkhakimov.measurementunitconverters.presentation.livedata.QuantityListItemsLiveData
import com.timkhakimov.measurementunitconverters.presentation.model.QuantityListItem
import com.timkhakimov.measurementunitconverters.presentation.navigation.Screen
import javax.inject.Inject

/**
 * Created by Timur Khakimov on 22.03.2020
 * ViewModel для экрана - список физ. величин
 */
class QuantitiesViewModel : BaseViewModel() {

    @Inject
    lateinit var quantityListLiveData: QuantityListItemsLiveData

    init {
        MeasurementUnitConvertersApplication.getComponent().inject(this)
    }

    fun selectQuantity(quantityListItem: QuantityListItem) {
        //todo выбрать величину и загрузить ед-цы измерения
        switchToScreen(Screen.SELECTED_QUANTITY)
    }
}