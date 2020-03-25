package com.timkhakimov.measurementunitconverters.presentation.viewmodel

import androidx.lifecycle.MutableLiveData
import com.timkhakimov.measurementunitconverters.MeasurementUnitConvertersApplication
import com.timkhakimov.measurementunitconverters.domain.interactors.UnitValuesInteractor
import com.timkhakimov.measurementunitconverters.presentation.handlers.EditedUnitValueHandler
import com.timkhakimov.measurementunitconverters.presentation.handlers.MainEditUnitValueHandler
import com.timkhakimov.measurementunitconverters.presentation.livedata.MeasurementUnitValuesLiveData
import com.timkhakimov.measurementunitconverters.presentation.model.MeasurementUnitValue
import com.timkhakimov.measurementunitconverters.presentation.model.QuantityListItem
import javax.inject.Inject

/**
 * Created by Timur Khakimov on 25.03.2020
 * ViewModel для экрана - список ед-ц измерения
 */
class SelectedQuantityViewModel : BaseViewModel(), EditedUnitValueHandler {

    @Inject
    lateinit var selectedQuantityListItemLiveData: MutableLiveData<QuantityListItem>
    @Inject
    lateinit var measurementUnitValuesLiveData: MeasurementUnitValuesLiveData
    @Inject
    lateinit var unitValuesInteractor: UnitValuesInteractor
    private val mainEditUnitValueHandler : MainEditUnitValueHandler

    init {
        MeasurementUnitConvertersApplication.getComponent().inject(this)
        mainEditUnitValueHandler = MainEditUnitValueHandler(unitValuesInteractor)
    }

    override fun handleEditedValue(measurementUnitValue: MeasurementUnitValue, editedString: String) {
        mainEditUnitValueHandler.handleEditedValue(measurementUnitValue, editedString)
    }
}