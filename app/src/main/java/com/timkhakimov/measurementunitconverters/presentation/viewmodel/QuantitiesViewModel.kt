package com.timkhakimov.measurementunitconverters.presentation.viewmodel

import androidx.lifecycle.MutableLiveData
import com.timkhakimov.measurementunitconverters.MeasurementUnitConvertersApplication
import com.timkhakimov.measurementunitconverters.domain.interactors.MeasurementUnitsInteractor
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
    @Inject
    lateinit var measurementUnitsInteractor: MeasurementUnitsInteractor
    @Inject
    lateinit var selectedQuantityListItemLiveData: MutableLiveData<QuantityListItem>

    init {
        MeasurementUnitConvertersApplication.getComponent().inject(this)
    }

    fun selectQuantity(quantityListItem: QuantityListItem) {
        measurementUnitsInteractor.loadMeasurementUnits(quantityListItem.quantity.id)
        selectedQuantityListItemLiveData.value = quantityListItem
        switchToScreen(Screen.SELECTED_QUANTITY)
    }
}