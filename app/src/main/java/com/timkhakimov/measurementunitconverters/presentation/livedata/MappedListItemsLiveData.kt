package com.timkhakimov.measurementunitconverters.presentation.livedata

import androidx.lifecycle.MutableLiveData
import com.timkhakimov.measurementunitconverters.domain.boundary.OutputBoundary
import com.timkhakimov.measurementunitconverters.domain.boundary.Resource
import com.timkhakimov.measurementunitconverters.presentation.mappers.ResourceListMapper

/**
 * Created by Timur Khakimov on 22.03.2020
 * LiveData для хранения списка элементов моделей из presentation-слоя
 * Реализует интерфейс OutputBoundary для приема данных из domain-слоя
 */
open class MappedListItemsLiveData<I, O>(private val resourceListMapper: ResourceListMapper<I, O>) :
    MutableLiveData<Resource<List<O>>>(), OutputBoundary<Resource<List<I>>> {

    override fun sendData(domainModelsResourse: Resource<List<I>>) {
        value = resourceListMapper.map(domainModelsResourse)
    }
}