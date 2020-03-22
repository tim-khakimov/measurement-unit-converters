package com.timkhakimov.measurementunitconverters.presentation.viewmodel

import com.timkhakimov.measurementunitconverters.MeasurementUnitConvertersApplication

/**
 * Created by Timur Khakimov on 22.03.2020
 * Основаная ViewModel для привязки к MainActivity
 */
class MainViewModel : BaseViewModel() {

    init {
        MeasurementUnitConvertersApplication.getComponent().inject(this)
    }
}