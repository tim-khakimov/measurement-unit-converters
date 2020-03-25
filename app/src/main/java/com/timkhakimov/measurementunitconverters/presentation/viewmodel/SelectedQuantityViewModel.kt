package com.timkhakimov.measurementunitconverters.presentation.viewmodel

import androidx.lifecycle.MutableLiveData
import com.timkhakimov.measurementunitconverters.MeasurementUnitConvertersApplication
import com.timkhakimov.measurementunitconverters.presentation.livedata.MeasurementUnitValuesLiveData
import com.timkhakimov.measurementunitconverters.presentation.model.QuantityListItem
import javax.inject.Inject

/**
 * Created by Timur Khakimov on 25.03.2020
 * ViewModel для экрана - список ед-ц измерения
 */
class SelectedQuantityViewModel : BaseViewModel() {

    @Inject
    lateinit var selectedQuantityListItemLiveData: MutableLiveData<QuantityListItem>
    @Inject
    lateinit var measurementUnitValuesLiveData: MeasurementUnitValuesLiveData

    init {
        MeasurementUnitConvertersApplication.getComponent().inject(this)
    }
}