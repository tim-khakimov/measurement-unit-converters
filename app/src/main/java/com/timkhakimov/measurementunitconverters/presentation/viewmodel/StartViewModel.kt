package com.timkhakimov.measurementunitconverters.presentation.viewmodel

import com.timkhakimov.measurementunitconverters.MeasurementUnitConvertersApplication
import com.timkhakimov.measurementunitconverters.domain.interactors.QuantitiesInteractor
import com.timkhakimov.measurementunitconverters.presentation.navigation.Screen
import javax.inject.Inject

/**
 * Created by Timur Khakimov on 22.03.2020
 * ViewModel для стартового экрана
 */
class StartViewModel : BaseViewModel() {

    @Inject
    lateinit var quantitiesInteractor: QuantitiesInteractor

    init {
        MeasurementUnitConvertersApplication.getComponent().inject(this)
    }

    fun onStartClicked() {
        quantitiesInteractor.loadQuantities()
        switchToScreen(Screen.QUANTITIES)
    }
}