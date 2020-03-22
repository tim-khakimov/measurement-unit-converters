package com.timkhakimov.measurementunitconverters.presentation.viewmodel

import com.timkhakimov.measurementunitconverters.MeasurementUnitConvertersApplication
import com.timkhakimov.measurementunitconverters.presentation.navigation.Screen

/**
 * Created by Timur Khakimov on 22.03.2020
 * ViewModel для стартового экрана
 */
class StartViewModel : BaseViewModel() {

    init {
        MeasurementUnitConvertersApplication.getComponent().inject(this)
    }

    fun onStartClicked() {
        switchToScreen(Screen.QUANTITIES)
    }
}