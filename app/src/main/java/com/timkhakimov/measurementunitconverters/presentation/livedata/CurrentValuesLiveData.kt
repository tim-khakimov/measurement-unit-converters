package com.timkhakimov.measurementunitconverters.presentation.livedata

import androidx.lifecycle.MutableLiveData
import com.timkhakimov.measurementunitconverters.domain.boundary.OutputBoundary

/**
 * Created by Timur Khakimov on 25.03.2020
 * LiveData для хранения конвертированных значений ед-ц измерения
 */
class CurrentValuesLiveData : MutableLiveData<Map<Int, Double>>(), OutputBoundary<Map<Int, Double>> {

    override fun sendData(data: Map<Int, Double>) {
        value = data
    }
}